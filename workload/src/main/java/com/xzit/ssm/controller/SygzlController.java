package com.xzit.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.Syworkload;
import com.xzit.ssm.excel.DataParser;
import com.xzit.ssm.excel.POIExcelUtils;
import com.xzit.ssm.excel.SyDataParser;
import com.xzit.ssm.excel1.ExcelOperator;
import com.xzit.ssm.excel1.IDataCellFormat;
import com.xzit.ssm.excel1.IObjectMapper;
import com.xzit.ssm.excel1.MergeZone;
import com.xzit.ssm.service.SyworkloadService;
import com.xzit.ssm.service.WorkloadService;
import com.xzit.ssm.vo.Datagrid;
import com.xzit.ssm.vo.SyworkloadVO;
import jxl.CellType;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by hjx on 2018/11/26 0026
 */
@Controller
public class SygzlController {
    @Autowired
    private WorkloadService workloadService;
    @Autowired
    private SyworkloadService syworkloadService;

    //实验课程分批清单文件上传
    @RequestMapping(method = RequestMethod.POST,value = "/syuploadfile")
    @ResponseBody
    public Datagrid<Syworkload> syuploadfile(@RequestParam(value = "uploadFile",required = false) MultipartFile file,
                                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("开始进行附件上传");
        //将数据封装为前端datagrid能显示的数据结构
        Datagrid<Syworkload> dg = new Datagrid<>();
        //读取Excel文件，解析表中的数据，Apache POI组件
        try{
            //读取Excel文件中的数据
            List<String[]> data = POIExcelUtils.readExcel(file,3,9);
            //根据规则解析这些数据
            //有问题的数据存放在一个集合中
            List<Syworkload> errorData = new ArrayList<Syworkload>();
            List<Syworkload> validData = new ArrayList<Syworkload>();
            //allData比data多一列，判断该数据是否存在问题
            List<String[]> syDatas = new ArrayList<String[]>();
            //解析数据
            SyDataParser.parserSykc(
                    DataParser.getTermMap(request),     //termMap
                    data,
                    errorData,
                    validData,
                    workloadService,
                    syDatas
            );

            //如果有非法的数据，返回非法数据
            if(errorData.size()>0){
                dg.setTotal(errorData.size());
                dg.setRows(errorData);
                //如果有错误将数据存储session中
                request.getSession().setAttribute("syDatas",syDatas);
            }else{
                request.getSession().removeAttribute("syDatas");
                //批量删除已存在的数据
                syworkloadService.deleteBatchByTermAndKchAndKxh(validData);
                //再完成数据批量导入
                syworkloadService.insertBatch(validData);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return dg;
    }

    /**
     * Excel文件数据下载所有数据，包括有问题的数据
     */
    @RequestMapping(method = RequestMethod.GET,value = "/sydatacheck")
    @ResponseBody
    public void excelDataCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("开始进行Excel下载");
        //Excel导出这些数据
        try {
            List<String[]> syDatas = (List<String[]>)request.getSession().getAttribute("syDatas");
            final ExcelOperator<String[]> excelTool = new ExcelOperator();
            excelTool.exportExcel(request, response,
                    "实验课程清单",
                    "课程实验环节多批次（包括单批次）实施数据表",
                    new String[]{"学年学期","课程号","课序号","课程名","上课教师","所属院系",
                                 "实验总学时","分批次数","每批次学时","校验结果"},
                    new int[]{30,20,15,30,20,30,
                            15,15,15,50},
                    syDatas,
                    new IObjectMapper<String[]>(){
                        @Override
                        public void toExcelRow(WritableSheet sheet,
                                               IDataCellFormat dataFormat, int rowNum,
                                               String[] data)
                                throws RowsExceededException, WriteException {
                            IDataCellFormat customdataFormat = excelTool.getDataFormat();
                            if(null!=data[data.length-1] && !"".equals(data[data.length-1])){
                                customdataFormat = excelTool.getCustomDataFormat();
                            }
                            //System.out.println(customdataFormat);
                            //"学年学期","课程号","课序号","课程名","上课教师","所属院系",
                            sheet.addCell(new Label(0, rowNum, data[0]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(1, rowNum, data[1]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(2, rowNum, data[2]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(3, rowNum, data[3]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(4, rowNum, data[4]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(5, rowNum, data[5]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            //"实验总学时","分批次数","每批次学时","校验结果",
                            sheet.addCell(new Label(6, rowNum, data[6]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(7, rowNum, data[7]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(8, rowNum, data[8]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                            sheet.addCell(new Label(9, rowNum, data[9]+"",customdataFormat.getDataCellFormat(CellType.STRING_FORMULA)));
                        }
                    },
                    new MergeZone(0, 0, 9, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //实验课程数据查询
    @RequestMapping(value = "/findsycourse")
    @ResponseBody
    public Datagrid<SyworkloadVO> findSyworkloadVO(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int rows,
            @RequestParam(value = "term",required = false,defaultValue = "0") Integer xq,
            @RequestParam(value = "department", required = false,defaultValue = "0")Integer xyid,
            @RequestParam(value = "kch", required = false,defaultValue = "")String kch,
            @RequestParam(value = "kxh", required = false,defaultValue = "")String kxh){
        //将数据封装为前端datagrid能显示的数据结构
        Datagrid<SyworkloadVO> dg = new Datagrid<SyworkloadVO>();
        //数据分页查询
        PageInfo<SyworkloadVO> pageinfo =
                syworkloadService.findSyworkloadsByPage(page,rows,xq,xyid,kch,kxh);
        dg.setTotal(pageinfo.getTotal());
        dg.setRows(pageinfo.getList());
        return dg;
    }

    //实验工作量统计
    @RequestMapping(value = "/sygzltotal")
    @ResponseBody
    public Map<String,Object> sygzltotal(){
        //查询哪些课程没有导入到实验课程计算列表中
        List<Curworkload> curworkloads = syworkloadService.findCurworkloadWithExpNoImport();

        if(curworkloads.size()>0)
        {
            //将每个课程信息转为Syworkload对象，并批量添加到syworkload数据表中
            List<Syworkload> syworkloads = new ArrayList<>();
            for (Curworkload cw : curworkloads) {
                Syworkload swl = new Syworkload();
                swl.setXyid(cw.getYxid());
                swl.setXq(cw.getXq());
                swl.setKch(cw.getKch());
                swl.setKxh(cw.getKxh());
                swl.setFpcx(1);
                swl.setFpxs(cw.getSjxs() + cw.getSyxs());
                swl.setSyzxs(cw.getSjxs() + cw.getSyxs());
                swl.setCwl(cw);
                //该课程实验工作量统计
                //非网络自主学习课程实验工作量计算
                String kclx1 = cw.getKclx1();
                if(!"网络自主学习课".equals(kclx1)){
                    SyDataParser.fpcsygzltotal(swl);
                }else {
                    swl.setFpgzl(swl.getSyzxs()*0.4f);
                }
                syworkloads.add(swl);
            }

            //批量删除已存在的数据
            syworkloadService.deleteBatchByTermAndKchAndKxh(syworkloads);
            //再完成数据批量导入
            syworkloadService.insertBatch(syworkloads);
        }

        //统计之后将实验工作量更新至curworkload表中
        //(1)各学期各课程的实验工作量（按xq+kch+kxh进行统计）
        List<Curworkload> kcsygzls = syworkloadService.sygzltotal();
        System.out.println("2");
        //(2)将实验工作量批量更新到curwork表中
      //  workloadService.updateBatchSJgzl(kcsygzls);
        System.out.println("3");
        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("msg","实验环节的全部数据已统计完成。");
        return map;
    }

    @RequestMapping(value = "/deleteallsydata")
    @ResponseBody
    public Map<String,Object> deleteAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        map.put("msg","实验环节的全部数据清理成功。");
        syworkloadService.deleteAll();
        return map;
    }
}
