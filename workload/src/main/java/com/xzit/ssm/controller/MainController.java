package com.xzit.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.College;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.Term;
import com.xzit.ssm.excel.DataParser;
import com.xzit.ssm.excel.NumberUtils;
import com.xzit.ssm.excel.POIExcelUtils;
import com.xzit.ssm.excel.StringUtils;
import com.xzit.ssm.excel1.*;
import com.xzit.ssm.service.CollegeService;
import com.xzit.ssm.service.OtherworkloadService;
import com.xzit.ssm.service.SyworkloadService;
import com.xzit.ssm.service.WorkloadService;
import com.xzit.ssm.vo.*;
import jxl.CellType;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * create by hjx on 2018/11/3 0003
 */
@Controller
public class MainController {

    @Autowired
    private WorkloadService workloadService;
    @Autowired
    private SyworkloadService syworkloadService;
    @Autowired
    private OtherworkloadService otherworkloadService;
    @Autowired
    private CollegeService collegeService;

    //主页
    @RequestMapping(value ="/main",method = RequestMethod.GET)
    public String index(){
        return "main";
    }
    //课程信息工作量窗口首页
    @RequestMapping(value ="/dataimport",method = RequestMethod.GET)
    public String dataimport(){
        return "dataimport";
    }
    //实践工作量窗口首页
    @RequestMapping(value ="/sjdataimport",method = RequestMethod.GET)
    public String sjdataimport(HttpServletRequest request,
                               @RequestParam(value = "term",required = false,defaultValue = "0") Integer xq,
                               @RequestParam(value = "department", required = false,defaultValue = "0")Integer xyid,
                               @RequestParam(value = "kch", required = false,defaultValue = "")String kch,
                               @RequestParam(value = "kxh", required = false,defaultValue = "")String kxh){
        request.setAttribute("xq",xq);
        request.setAttribute("xyid",xyid);
        request.setAttribute("kch",kch);
        request.setAttribute("kxh",kxh);

        return "dataimport-sj";
    }
    //其它工作量窗口首页
    @RequestMapping(value ="/othergzlindex",method = RequestMethod.GET)
    public String otherworkload(){
        return "othergzllist";
    }

    //课程清单文件上传
    @RequestMapping(method = RequestMethod.POST,value = "/uploadfile")
    @ResponseBody
    public Datagrid<Curworkload> excelDataUpload(@RequestParam(value = "uploadFile",required = false) MultipartFile file,
                   HttpServletRequest request, HttpServletResponse response) throws Exception{
        //System.out.println("开始进行附件上传");
        //将数据封装为前端datagrid能显示的数据结构
        Datagrid<Curworkload> dg = new Datagrid<>();
        //读取Excel文件，解析表中的数据，Apache POI组件
        try{
            //读取Excel文件中的数据
            List<String[]> data = POIExcelUtils.readExcel(file,3,20);
            //根据规则解析这些数据
            //有问题的数据存放在一个集合中
            List<Curworkload> errorData = new ArrayList<Curworkload>();
            List<Curworkload> validData = new ArrayList<Curworkload>();
            //所有的数据
            List<Curworkload> cwlDatas = new ArrayList<Curworkload>();
            //解析数据
            DataParser.parser(
                    DataParser.getTermMap(request),     //termMap
                    DataParser.getCollegeMap(request),  //collegeMap
                    data,                               //
                    errorData,
                    validData,
                    cwlDatas);
            //判断是否有主键重复的数据，即:xq+kch+kxh有重复的
            List<Curworkload> duplicateData = new ArrayList<Curworkload>();
            DataParser.duplicateWorkload(duplicateData,cwlDatas);

            //如果有非法的数据，返回非法数据
            if(errorData.size()>0||duplicateData.size()>0){
                errorData.addAll(duplicateData);
                dg.setTotal(errorData.size());
                dg.setRows(errorData);
                //如果有错误将数据存储session中
                request.getSession().setAttribute("cwlDatas",cwlDatas);
            }else{
                request.getSession().removeAttribute("cwlDatas");
                //完成数据批量导入
                List<Curworkload> insertList = new ArrayList<Curworkload>();
                List<Curworkload> updateList = new ArrayList<Curworkload>();
                DataParser.divide(validData, workloadService, insertList, updateList);
                //完成批量添加
                if (insertList.size() > 0)
                    workloadService.insertBatch(insertList);
                if (updateList.size() > 0)
                    workloadService.updateBatch(updateList);

            }
            //否则返回合法数据
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return dg;
    }

    /**
     * Excel文件数据下载所有数据，包括有问题的数据
     */
    @RequestMapping(method = RequestMethod.GET,value = "/datacheck")
    @ResponseBody
    public void excelDataCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //System.out.println("开始进行Excel下载");
        //Excel导出这些数据
        try {
                List<Curworkload> cwlDatas = (List<Curworkload>)request.getSession().getAttribute("cwlDatas");
                final ExcelOperator<Curworkload> excelTool = new ExcelOperator<Curworkload>();
                excelTool.exportExcel(request, response,
                        "课程清单",
                        "课程清单",
                        new String[]{"学年学期","课程号","课序号","课程名","上课教师","职称",
                                     "院系","课程属性","班级","上课人数","总学时","授课学时",
                                     "上机学时","实验学时","学分","课程类别","是否专业核心课","备注",
                                     "课程类型1","课程类型2","校验结果"},
                        new int[]{16,16,10,30,20,20,
                                  30,30,50,10,10,10,
                                  10,10,10,10,15,20,
                                  20,20,50},
                        cwlDatas,
                        new IObjectMapper<Curworkload>(){
                            @Override
                            public void toExcelRow(WritableSheet sheet,
                                                   IDataCellFormat dataFormat, int rowNum,
                                                   Curworkload cwl)
                                    throws RowsExceededException, WriteException {
                                    Term term = cwl.getTerm();
                                    String xqstr = "--";
                                    if(term!=null) xqstr = term.getTermname();
                                    College college = cwl.getCollege();
                                    String xystr = "";
                                    if(college!=null) xystr = college.getName();
                                    //"学年学期","课程号","课序号","课程名","上课教师","职称"
                                    IDataCellFormat customdataFormat = excelTool.getDataFormat();
                                    if(!"".equals(cwl.getErrmsg())){
                                        customdataFormat = excelTool.getCustomDataFormat();
                                    }
                                    //System.out.println(customdataFormat);
                                    //"学年学期","课程号","课序号","课程名","上课教师","职称",
                                    sheet.addCell(new Label(0, rowNum, xqstr+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(1, rowNum, cwl.getKch(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(2, rowNum, cwl.getKxh(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(3, rowNum, cwl.getKcm(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(4, rowNum, cwl.getSkls(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(5, rowNum, cwl.getLszc(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    //"院系","课程属性","班级","上课人数","总学时","授课学时",
                                    sheet.addCell(new Label(6, rowNum, xystr,customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(7, rowNum, cwl.getKcsx(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(8, rowNum, cwl.getBjmc(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(9, rowNum, cwl.getXkrs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(10, rowNum, cwl.getZxs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(11, rowNum, cwl.getSkxs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    //"上机学时","实验学时","学分","课程类别","是否专业核心课","备注",
                                    sheet.addCell(new Label(12, rowNum, cwl.getSjxs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(13, rowNum, cwl.getSyxs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(14, rowNum, cwl.getXf()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(15, rowNum, cwl.getKclx()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(16, rowNum, cwl.getSfcxk()==0?"":"是",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(17, rowNum, cwl.getBz()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    //"课程类型1","课程类型2","校验结果"
                                    sheet.addCell(new Label(18, rowNum, cwl.getKclx1()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(19, rowNum, cwl.getKclx2()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                                    sheet.addCell(new Label(20, rowNum, cwl.getErrmsg()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            }
                        },
                        new MergeZone(0, 0, 20, 1));
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

    //数据查询
    @RequestMapping(value = "/findcourse")
    @ResponseBody
    public Datagrid<Curworkload> findcourses(
            //表单中条件查询参数也可以通过HttSerlvetRequest的get获取参数
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int rows,
            @RequestParam(value = "term",required = false,defaultValue = "0") Integer xq,
            @RequestParam(value = "department", required = false,defaultValue = "0")Integer xyid,
            @RequestParam(value = "coursetype", required = false,defaultValue = "") String coursetype,
            @RequestParam(value = "kcm", required = false,defaultValue = "") String kcm,
            @RequestParam(value = "skls", required = false,defaultValue = "") String skls){
        //将数据封装为前端datagrid能显示的数据结构
        Datagrid<Curworkload> dg = new Datagrid<>();
        //数据分页查询
        PageInfo<Curworkload> pageinfo =
                workloadService.findCurworkloadsByPage(
                        page,rows,xq,xyid,coursetype,kcm,skls);
        dg.setTotal(pageinfo.getTotal());
        dg.setRows(pageinfo.getList());
        return dg;
    }

    //显示Echart图表的信息--模拟数据
    @RequestMapping(value = "/generatorBarEchartBar1")
    @ResponseBody
    public BarEchartData generatorBarEchartBar1(int termid){
        List<String> category = Arrays.asList("a","b","c","d","e","f","g","h","i");
        List<Float> llgzldata = Arrays.asList(new Float[]{100.3f,50f,36f,78f,125f,263f,200f,123f,232f});
        List<Float> sjgzldata = Arrays.asList(new Float[]{100.3f,50f,36f,78f,125f,263f,200f,123f,232f});
        List<Float> othergzldata = Arrays.asList(new Float[]{100.3f,50f,36f,78f,125f,263f,200f,123f,232f});
        BarEchartData echartData = new BarEchartData(category,llgzldata,sjgzldata,othergzldata);
        return echartData;
    }

    //显示Echart图表的信息
    @RequestMapping(value = "/generatorBarEchartBar")
    @ResponseBody
    public BarEchartData generatorBarEchartBar(int termid,HttpServletRequest request){
        List<GzlVO> gzls = workloadService.gzltotalByCollege();
        List<String> category = new ArrayList<>();
        List<Float> llgzldata = new ArrayList<>();
        List<Float> sjgzldata = new ArrayList<>();
        List<Float> othergzldata = new ArrayList<>();
        float sumlljxgzl = 0.0f;
        float sumsjjxgzl = 0.0f;
        float sumothergzl = 0.0f;
        float total = 0.0f;
        for(GzlVO gzlvo:gzls){
            category.add(gzlvo.getNick());
            llgzldata.add(gzlvo.getLljxgzl());
            sjgzldata.add(gzlvo.getSjjxgzl());
            othergzldata.add(gzlvo.getOthergzl());
            sumlljxgzl+= gzlvo.getLljxgzl();
            sumsjjxgzl+= gzlvo.getSjjxgzl();
            sumothergzl+= gzlvo.getOthergzl();
        }
        total = NumberUtils.decimalwithtwo(sumlljxgzl + sumsjjxgzl + sumothergzl);
        //System.out.println("total=" + total);
        BarEchartData echartData = new BarEchartData(category,llgzldata,sjgzldata,othergzldata);
        echartData.setGzldata(gzls);
        //构建Datagrid数据表格
        Datagrid<GzlVO> datagrid = new Datagrid<>();
        datagrid.setRows(gzls);
        datagrid.setTotal(gzls.size());
        //全校工作量之和
        List<Map<String,Object>> mapList1=new ArrayList<Map<String,Object>>();
        Map<String,Object> tmap1=new HashMap<String,Object>();
        tmap1.put("collid",0);
        tmap1.put("lljxgzl", NumberUtils.decimalwithtwo(sumlljxgzl));
        tmap1.put("sjjxgzl", NumberUtils.decimalwithtwo(sumsjjxgzl));
        tmap1.put("othergzl", NumberUtils.decimalwithtwo(sumothergzl));
        tmap1.put("totalgzl", total);
        tmap1.put("nick", "全校总工作量");
        mapList1.add(tmap1);
        datagrid.setFooter(mapList1);
        echartData.setDatagrid(datagrid);
        return echartData;
    }

    //所有学院工作量导出
    @RequestMapping(value = "/allgzlexport")
    public void allgzlexport(HttpServletRequest request, HttpServletResponse response){
        try {
            List<GzlVO> gzls = workloadService.gzltotalByCollege();
            float sumlljxgzl = 0.0f;
            float sumsjjxgzl = 0.0f;
            float sumothergzl = 0.0f;
            float total = 0.0f;
            for(GzlVO gzlvo:gzls){
                sumlljxgzl+= gzlvo.getLljxgzl();
                sumsjjxgzl+= gzlvo.getSjjxgzl();
                sumothergzl+= gzlvo.getOthergzl();
            }
            total = NumberUtils.decimalwithtwo(sumlljxgzl + sumsjjxgzl + sumothergzl);
            GzlVO totalVo = new GzlVO();
            totalVo.setCollid(0);
            totalVo.setNick("教学工作量合计");
            totalVo.setLljxgzl(NumberUtils.decimalwithtwo(sumlljxgzl));
            totalVo.setSjjxgzl(NumberUtils.decimalwithtwo(sumsjjxgzl));
            totalVo.setOthergzl(NumberUtils.decimalwithtwo(sumothergzl));
            totalVo.setKcsumgzl(NumberUtils.decimalwithtwo(sumlljxgzl+sumsjjxgzl));
            totalVo.setTotalgzl(total);
            gzls.add(totalVo);
            //Excel导出各个学院的工作量
            final ExcelOperator<GzlVO> excelTool = new ExcelOperator<>();
            final IDataCellFormat customdataFormat = excelTool.getDataFormat();
            final jxl.write.WritableCellFormat wcfN = customdataFormat.getDataCellFormat(CellType.NUMBER);
            excelTool.exportExcel(request, response,
                    "教学工作量-全校",
                    "本年度全校教学工作量合计",
                    new String[]{"部门名称","理论课程工作量","实践课程工作量","其它补贴工作量","工作量合计"},
                    new int[]{30,30,30,30,30},
                    gzls,
                    new IObjectMapper<GzlVO>(){
                        @Override
                        public void toExcelRow(WritableSheet sheet,
                                               IDataCellFormat dataFormat, int rowNum,
                                               GzlVO gzlvo)
                                throws RowsExceededException, WriteException {
                            //"部门名称","理论课程工作量","实践课程工作量","其它补贴工作量","工作量合计"
                            sheet.addCell(new Label(0, rowNum, gzlvo.getNick()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Number(1, rowNum, gzlvo.getLljxgzl(),wcfN));
                            sheet.addCell(new Number(2, rowNum, gzlvo.getSjjxgzl(),wcfN));
                            sheet.addCell(new Number(3, rowNum, gzlvo.getOthergzl(),wcfN));
                            sheet.addCell(new Number(4, rowNum, gzlvo.getTotalgzl(),wcfN));
                        }
                    },
                    new MergeZone(0, 0, 4, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除课程数据
    @RequestMapping(value = "/deletecoursedata")
    @ResponseBody
    public Map<String,Object> deleteAllCoursedata(){
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        map.put("msg","课程清单及实验分配数据清理完毕。");
        syworkloadService.deleteAll();
        workloadService.deleteAll();
        return map;
    }

    //统计结果导出
    @RequestMapping(method = RequestMethod.GET,value = "/totalexport")
    @ResponseBody
    public void totalexport(HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam(defaultValue = "0") int xyid) throws Exception {
        //System.out.println("统计结果导出");
        //学院信息
        final College college = collegeService.findByCollid(xyid);
        //Excel导出
        OutputStream out = null;
        WritableWorkbook wbook = null;
        try{
            out = response.getOutputStream();
            response.setContentType("application/msexcel");// 定义输出类型
            String fileName = "教学工作量-" + college.getNick();
            // 获取浏览器类型
            String user_agent = request.getHeader("User-Agent").toLowerCase();
            // 为不同的浏览器，对文件名进行不同的编码转换
            if (user_agent.indexOf("firefox") > 0) {
                fileName = new String(fileName.getBytes("UTF-8"), "iso8859-1");
            } else {
                fileName = URLEncoder.encode(fileName, "UTF-8");
            }

            response.setHeader("Content-disposition", "attachment; filename="
                    + fileName + ".xls"); // 设定输出文件头

            wbook = Workbook.createWorkbook(out); // 建立excel文件

            //包括两学期的教学工作量（理论+实践）、（实验分批统计）、其他工作量
            //总的工作量、第1学期理论+实践工作量、第2学期理论+实践工作量、两学期其他工作量
            List<TermGzlVo> termGzlVos = workloadService.termgzltotalByCollege(xyid);
            TermGzlVo hjGzl = new TermGzlVo();
            hjGzl.setTermname("--合计--");
            for(TermGzlVo vo:termGzlVos){
                hjGzl.setLljxgzl(hjGzl.getLljxgzl()+vo.getLljxgzl());
                hjGzl.setSjjxgzl(hjGzl.getSjjxgzl()+vo.getSjjxgzl());
                hjGzl.setOthergzl(hjGzl.getOthergzl() + vo.getOthergzl());
                hjGzl.setKcsumgzl(hjGzl.getKcsumgzl()+vo.getKcsumgzl());
            }
            termGzlVos.add(hjGzl);


            //在sheet=0的表格中输出总的统计数据
            final ExcelOperator<TermGzlVo> operator1 = new ExcelOperator<>();
            //样式
            final IDataCellFormat customdataFormat = operator1.getDataFormat();
            final jxl.write.WritableCellFormat wcfN = customdataFormat.getDataCellFormat(CellType.NUMBER);

            operator1.exportMultisheetExcel(wbook, "本年度总的工作量", "本年度所有工作量清单",
                    new String[]{"学院名称","所属学期","理论教学工作量","实践教学工作量","其它教学工作量","小计"},
                    new int[]{15,15,20,20,20,20}, termGzlVos, new IObjectMapper<TermGzlVo>() {
                        @Override
                        public void toExcelRow(WritableSheet sheet, IDataCellFormat dataFormat, int rowNum, TermGzlVo gzlVo) throws RowsExceededException, WriteException {
                            //IDataCellFormat customdataFormat = operator1.getDataFormat();
                            //"学年学期","课程号","课序号","课程名","上课教师","职称",
                            sheet.addCell(new Label(0, rowNum, college.getNick()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(1, rowNum, gzlVo.getTermname()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));

                            //jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##"); //设置数字格式
                            //jxl.write.WritableCellFormat wcfN = new jxl.write.WritableCellFormat(nf); //设置表单格式
                            //jxl.write.WritableCellFormat wcfN = customdataFormat.getDataCellFormat(CellType.NUMBER);
                            sheet.addCell(new jxl.write.Number(2, rowNum, gzlVo.getLljxgzl(),wcfN));
                            sheet.addCell(new jxl.write.Number(3, rowNum, gzlVo.getSjjxgzl(),wcfN));
                            sheet.addCell(new jxl.write.Number(4, rowNum, gzlVo.getOthergzl(),wcfN));
                            sheet.addCell(new jxl.write.Number(5, rowNum, gzlVo.getSumgzl(),wcfN));

                        }
                    },new MergeZone(0,0,5,0),0);
            //在sheet=1的表格中输出理论课+实践课数据
            //每学期的工作量
            List<Curworkload> twoTermgzldetails = workloadService.twoTermgzldetails(xyid);

            final ExcelOperator<Curworkload> operator2 = new ExcelOperator<>();
            operator2.exportMultisheetExcel(
                    wbook,
                    "本年度课程教学工作量",
                    "课程教学工作量清单",
                    new String[]{"学年学期","课程号","课序号","课程名","上课教师","职称",
                            "院系","课程属性","班级","上课人数","总学时","授课学时",
                            "上机学时","实验学时","学分","课程类别","是否专业核心课","备注",
                            "课程类型1","课程类型2","课程系数","人数系数","理论工作量","实践工作量",
                            "小计"},
                    new int[]{16,16,10,30,20,20,
                            30,30,50,10,10,10,
                            10,10,10,10,15,20,
                            20,10,10,20,20,20,20},
                    twoTermgzldetails,
                    new IObjectMapper<Curworkload>(){
                        @Override
                        public void toExcelRow(WritableSheet sheet,
                                               IDataCellFormat dataFormat, int rowNum,
                                               Curworkload cwl)
                                throws RowsExceededException, WriteException {
                            Term term = cwl.getTerm();
                            String xqstr = term.getTermname();
                            College college = cwl.getCollege();
                            String xystr = xystr = college.getName();
                            //"学年学期","课程号","课序号","课程名","上课教师","职称"
                            //IDataCellFormat customdataFormat = operator2.getDataFormat();
                            //"学年学期","课程号","课序号","课程名","上课教师","职称",
                            sheet.addCell(new Label(0, rowNum, xqstr+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(1, rowNum, cwl.getKch(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(2, rowNum, cwl.getKxh(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(3, rowNum, cwl.getKcm(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(4, rowNum, cwl.getSkls(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(5, rowNum, cwl.getLszc(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            //"院系","课程属性","班级","上课人数","总学时","授课学时",
                            sheet.addCell(new Label(6, rowNum, xystr,customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(7, rowNum, cwl.getKcsx(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(8, rowNum, cwl.getBjmc(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(9, rowNum, cwl.getXkrs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(10, rowNum, cwl.getZxs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(11, rowNum, cwl.getSkxs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            //"上机学时","实验学时","学分","课程类别","是否专业核心课","备注",
                            sheet.addCell(new Label(12, rowNum, cwl.getSjxs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(13, rowNum, cwl.getSyxs()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(14, rowNum, cwl.getXf()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(15, rowNum, cwl.getKclx()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(16, rowNum, cwl.getSfcxk()==0?"":"是",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(17, rowNum, cwl.getBz()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            //"课程类型1","课程类型2","校验结果","课程系数","人数系数","理论工作量","实践工作量","小计"
                            sheet.addCell(new Label(18, rowNum, cwl.getKclx1()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(19, rowNum, cwl.getKclx2()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(20, rowNum, cwl.getKcxs()+"",customdataFormat.getDataCellFormat(CellType.NUMBER)));
                            sheet.addCell(new Label(21, rowNum, cwl.getRsxs()+"",customdataFormat.getDataCellFormat(CellType.NUMBER)));
                            sheet.addCell(new Number(22, rowNum, cwl.getLljxgzl(),wcfN));
                            sheet.addCell(new Number(23, rowNum, cwl.getSjjxgzl(),wcfN));
                            sheet.addCell(new Number(24, rowNum, cwl.getSumgzl(),wcfN));
                        }
                    },
                    new MergeZone(0, 0, 24, 0),1);
            //每学期工作量补贴
            List<OtherworkloadVO> twoTermOthergzldetails =
                    otherworkloadService.findByTermidAndCollid(0,xyid);
            final ExcelOperator<OtherworkloadVO> operator3 = new ExcelOperator<>();
            operator3.exportMultisheetExcel(
                    wbook,
                    "其它工作量补贴",
                    "本年度其它工作量补贴清单",
                    new String[]{"学年学期","学院名称","补贴工作量","补贴项目名称","说明"},
                    new int[]{20,20,20,30,50},
                    twoTermOthergzldetails,
                    new IObjectMapper<OtherworkloadVO>(){
                        @Override
                        public void toExcelRow(WritableSheet sheet,
                                               IDataCellFormat dataFormat, int rowNum,
                                               OtherworkloadVO cwl)
                                throws RowsExceededException, WriteException {
                            String xqstr = cwl.getTermname();
                            String xystr = xystr = cwl.getName();
                            //"学年学期","学院名称","补贴工作量","补贴项目名称","说明"
                            //IDataCellFormat customdataFormat = operator3.getDataFormat();
                            sheet.addCell(new Label(0, rowNum, xqstr+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(1, rowNum, xystr+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            //jxl.write.WritableCellFormat wcfN = customdataFormat.getDataCellFormat(CellType.NUMBER);
                            sheet.addCell(new Number(2, rowNum, cwl.getGzl(),wcfN));
                            sheet.addCell(new Label(3, rowNum, cwl.getGzlmc()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(4, rowNum, cwl.getBrief(),customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                        }
                    },
                    new MergeZone(0, 0, 4, 0),2);
            //实验课程分配统计表
            List<SyworkloadVO> sywldatas = syworkloadService.findSyworkloadsByTermidAndCollegeId(0, xyid);
            final ExcelOperator<SyworkloadVO> operator4 = new ExcelOperator<>();
            operator4.exportMultisheetExcel(
                    wbook,
                    "实验分批次明细",
                    "本年度实验课程分批次工作量明细表",
                    new String[]{"学年学期","学院名称","课程号","课序号","课程名","授课老师",
                                 "授课班级","选课人数","总学时","实验学时","分批次数","分批学时","工作量小计"},
                    new int[]{20,20,20,10,20,20,
                               50,20,20,20,15,15,20},
                    sywldatas,
                    new IObjectMapper<SyworkloadVO>(){
                        @Override
                        public void toExcelRow(WritableSheet sheet,
                                               IDataCellFormat dataFormat, int rowNum,
                                               SyworkloadVO cwl)
                                throws RowsExceededException, WriteException {
                            String xqstr = cwl.getTermname();
                            String xystr = xystr = cwl.getName();
                            //"学年学期","学院名称","课程号","课序号","课程名","授课老师"
                            sheet.addCell(new Label(0, rowNum, xqstr+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(1, rowNum, xystr+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(2, rowNum, cwl.getKch()+"",customdataFormat.getDataCellFormat(CellType.NUMBER)));
                            sheet.addCell(new Label(3, rowNum, cwl.getKxh()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(4, rowNum, cwl.getKcm()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(5, rowNum, cwl.getSkls()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            //"授课班级","总学时","实验学时","分批次数","分批学时","工作量小计"
                            sheet.addCell(new Label(6, rowNum, cwl.getBjmc()+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Number(7,rowNum,cwl.getXkrs(),wcfN));
                            sheet.addCell(new Number(8,rowNum,cwl.getZxs(),wcfN));
                            sheet.addCell(new Number(9,rowNum,cwl.getSyxs(),wcfN));
                            sheet.addCell(new Number(10,rowNum,cwl.getFpcx(),wcfN));
                            sheet.addCell(new Number(11,rowNum,cwl.getFpxs(),wcfN));
                            sheet.addCell(new Number(12,rowNum,cwl.getFpgzl(),wcfN));
                        }
                    },
                    new MergeZone(0, 0, 12, 0),3);
            // 主体内容生成结束
            wbook.write(); // 写入文件
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (wbook != null) {
                try {
                    wbook.close();
                } catch (WriteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }




    }



}
