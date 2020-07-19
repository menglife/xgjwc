package com.xzit.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.College;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.Syworkload;
import com.xzit.ssm.entity.Term;
import com.xzit.ssm.excel.DataParser;
import com.xzit.ssm.excel.NumberUtils;
import com.xzit.ssm.excel.StringUtils;
import com.xzit.ssm.service.SyworkloadService;
import com.xzit.ssm.service.WorkloadService;
import com.xzit.ssm.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class datacheckController {
    @Autowired
    WorkloadService workloadService;
    @Autowired
    SyworkloadService syworkloadService;
    //数据查询
    @RequestMapping(value = "checkinfo",method = RequestMethod.POST)
    @ResponseBody
    public  Datagrid<Curworkload> checkinfo(     @RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "20") int rows,
                                                   @RequestParam(value = "term",required = false,defaultValue = "0") Integer xq,
                                                   @RequestParam(value = "department", required = false,defaultValue = "0")Integer xyid,
                                                   @RequestParam(value = "coursetype", required = false,defaultValue = "") String coursetype,
                                                   @RequestParam(value = "kcm", required = false,defaultValue = "") String kcm,
                                                   @RequestParam(value = "skls", required = false,defaultValue = "") String skls,HttpSession session){

        Datagrid<Curworkload> dg = new Datagrid<>();
        PageInfo<Curworkload> pageinfo =
                workloadService.findCurworkloadsByPage(
                        page,rows,xq,(int)session.getAttribute("xyid"),coursetype,kcm,skls);
        dg.setTotal(pageinfo.getTotal());
        dg.setRows(pageinfo.getList());
        DataParser dataParser=new DataParser();
        Curworkload curworkload=new Curworkload();
        for(int j=0;j<(int)session.getAttribute("rows");j++){
            //校验1课程系数
            float f= dg.getRows().get(j).getKcxs();
            float rsxs=dg.getRows().get(j).getRsxs();
            float xf=dg.getRows().get(j).getXf();
            int zxs=dg.getRows().get(j).getZxs();
            int sjxs=dg.getRows().get(j).getSjxs();
            int skxs=dg.getRows().get(j).getSkxs();
            int xkrs=dg.getRows().get(j).getXkrs();
            String flag="T";
            if (!(dg.getRows().get(j).getKcxs().equals(xscalcuate( dg.getRows().get(j)).getKcxs()))){
                dg.getRows().get(j).setCwd("F");
                dg.getRows().get(j).setJy(xscalcuate( dg.getRows().get(j)).getKcxs().toString());
                dg.getRows().get(j).setErrmsg("课程系数"+f);//校验前
                dg.getRows().get(j).setKcxs(f);
                curworkload.setCwd("课程系数"+Float.toString(f)+"正确结果"+xscalcuate( dg.getRows().get(j)).getKcxs().toString());
                curworkload.setId(dg.getRows().get(j).getId());
                workloadService.updatacwd(curworkload);
                flag="F";
            }
            //校验2人数系数

            if (rsxs!=RatioStuNumber.ratio(dg.getRows().get(j).getKclx2(),dg.getRows().get(j).getXkrs())){
                dg.getRows().get(j).setCwd("F");
                dg.getRows().get(j).setJy(Float.toString(RatioStuNumber.ratio(dg.getRows().get(j).getKclx2(),dg.getRows().get(j).getXkrs())));//校验后
                dg.getRows().get(j).setErrmsg("人数系数"+rsxs);//校验前
                dg.getRows().get(j).setRsxs(rsxs);
                curworkload.setId(dg.getRows().get(j).getId());
                curworkload.setCwd("人数系数"+rsxs+"正确结果"+RatioStuNumber.ratio(dg.getRows().get(j).getKclx2(),dg.getRows().get(j).getXkrs()));
                workloadService.updatacwd(curworkload);
                flag="F";
            }
            //校验3学分

            if (xf!= getXf(dg.getRows().get(j).getXf().toString(),dg.getRows().get(j)).getXf()){
                dg.getRows().get(j).setCwd("F");
                dg.getRows().get(j).setErrmsg("学分默认值"+getXf(dg.getRows().get(j).getXf().toString(),dg.getRows().get(j)).getXf()+"学分数数据不合法;");
                dg.getRows().get(j).setXf(xf);
                curworkload.setId(dg.getRows().get(j).getId());
                curworkload.setCwd("学分"+xf+"学分数数据不合法;");
                workloadService.updatacwd(curworkload);
                flag="F";
            }
            //总学时

            if (zxs!=jyxs(dg.getRows().get(j)).getZxs()){
                dg.getRows().get(j).setCwd("F");
                dg.getRows().get(j).setJy(Integer.toString(jyxs(dg.getRows().get(j)).getZxs()));
                dg.getRows().get(j).setErrmsg("总学时"+zxs);
                dg.getRows().get(j).setZxs(zxs);
                curworkload.setId(dg.getRows().get(j).getId());
                curworkload.setCwd("总学时"+zxs+"不正确;");
                workloadService.updatacwd(curworkload);
                flag="F";
            }

            //上机学时

            if (sjxs!=getSjxs(dg.getRows().get(j).getSjxs().toString(),dg.getRows().get(j)).getSjxs()){
                dg.getRows().get(j).setCwd("F");
                dg.getRows().get(j).setJy(Integer.toString(getSjxs(dg.getRows().get(j).getSjxs().toString(),dg.getRows().get(j)).getSjxs()));
                dg.getRows().get(j).setErrmsg("上机学时"+ getSjxs(dg.getRows().get(j).getSjxs().toString(),dg.getRows().get(j)).getSjxs());
                curworkload.setId(dg.getRows().get(j).getId());
                curworkload.setCwd("上机学时"+sjxs+"不正确;");
                workloadService.updatacwd(curworkload);
                flag="F";

            }
            //授课学时

            if (skxs!=getSkxs(dg.getRows().get(j).getSkxs().toString(),dg.getRows().get(j)).getSkxs()){
                dg.getRows().get(j).setCwd("F");
                dg.getRows().get(j).setJy(Integer.toString(getSkxs(dg.getRows().get(j).getSjxs().toString(),dg.getRows().get(j)).getSkxs()));
                dg.getRows().get(j).setErrmsg("授课学时"+getSkxs(dg.getRows().get(j).getSkxs().toString(),dg.getRows().get(j)).getSkxs());
                curworkload.setId(dg.getRows().get(j).getId());
                curworkload.setCwd("授课学时"+skxs+"不正确;");
                workloadService.updatacwd(curworkload);
                flag="F";
            }

//选课人数
            if(xkrs!=getXkrs(dg.getRows().get(j).getXkrs().toString(),dg.getRows().get(j)).getXkrs()){
                dg.getRows().get(j).setCwd("F");
                dg.getRows().get(j).setJy(Integer.toString(getXkrs(dg.getRows().get(j).getXkrs().toString(),dg.getRows().get(j)).getXkrs()));
                dg.getRows().get(j).setErrmsg("选课人数"+getXkrs(dg.getRows().get(j).getXkrs().toString(),dg.getRows().get(j)).getXkrs());
                curworkload.setId(dg.getRows().get(j).getId());
                curworkload.setCwd("选课人数学时"+xkrs+"不正确;");
                workloadService.updatacwd(curworkload);
                flag="F";
            }
            if (flag.equals("T")){
                curworkload.setId(dg.getRows().get(j).getId());
                curworkload.setCwd("");
                dg.getRows().get(j).setCwd("");
                workloadService.updatacwd(curworkload);
            }
            //实验学时

//            getSyxs(dg.getRows().get(j).getSyxs().toString(),dg.getRows().get(j));
//            if (!(dg.getRows().get(j).getSyxs().equals(getSyxs(dg.getRows().get(j).getSyxs().toString(),dg.getRows().get(j)).getSjxs()))){
//                dg.getRows().get(j).setErrmsg("实验学时"+ getSyxs(dg.getRows().get(j).getSyxs().toString(),dg.getRows().get(j)).getSyxs());
//            }





        }
        return dg ;
    }
    //系数
    public Curworkload xscalcuate(Curworkload cwk){
        //（1）课程系数  根据课程类型找系数
        //根据课程类型kcxl
        String kclx = cwk.getKclx();
        kclx = kclx!=null?kclx:"";
        kclx = StringUtils.chinese(kclx);
        if("学科基础课,专业基础课,高等数学,大学物理".contains(kclx)){
            cwk.setKcxs(1.1f);
            cwk.setKclx3("学科基础课");
            cwk.setBz("学科基础课");
        }else if("集中实践课".equals(kclx)){
            cwk.setSkxs(0);
            cwk.setSjxs(0);
            cwk.setSyxs(0);
            cwk.setZxs(0);
            cwk.setKclx3("集中实践课");
            //备注
            String bz = cwk.getBz();
            bz = bz!=null?bz:"";
            bz = StringUtils.chinese(bz);
            if("".equals(bz)){
                cwk.setErrmsg(cwk.getErrmsg()+ "," + cwk.getKcm() + "备注数据不合法;");
            }else if("课程设计".equals(bz)){
                // 实践教学工作量 =  学分*(选课人数/25)*10; 课程类型3=课程设计
                float sjjxgzl = cwk.getXf()*(cwk.getXkrs()/25.0f)*10;
                cwk.setSjjxgzl(NumberUtils.decimalwithtwo(sjjxgzl));
                //cwk.setKclx3("课程设计");
            }else if("学年论文".equals(bz)||"学年期论文".equals(bz)){
                // 实践教学工作量 =  学分*(选课人数/25)*8; 课程类型3=学年论文
                float sjjxgzl = cwk.getXf()*(cwk.getXkrs()/25.0f)*8;
                cwk.setSjjxgzl(NumberUtils.decimalwithtwo(sjjxgzl));
                //cwk.setKclx3("学年论文");
            }else if("毕业设计".equals(bz)||"毕业设计论文".equals(bz)||"毕业论文".equals(bz)){
                // 实践教学工作量 =   (学分+1)*选课人数; 课程类型3=毕业设计
                float sjjxgzl = (cwk.getXf()+1)*cwk.getXkrs();
                cwk.setSjjxgzl(NumberUtils.decimalwithtwo(sjjxgzl));
                //cwk.setKclx3("毕业设计");
            }else if("实习实训".equals(bz)){
                //实习实训
                String kcxl1 = StringUtils.chinese(cwk.getKclx1());
                Trainee trainee = Trainee.getTrainee(kcxl1);
                if(trainee==null){
                    cwk.setErrmsg(cwk.getErrmsg() +  "," + "课程类型1数据不合法;");
                }else{
                    //实习（实训）工作量=计划周数×（学生数÷N）×10 学时×K
                    float sjjxgzl = cwk.getXf()*(cwk.getXkrs()*1.0f/trainee.getN())*10*trainee.getK();
                    cwk.setSjjxgzl(NumberUtils.decimalwithtwo(sjjxgzl));
                    //System.out.println(cwk.getKch() + "-" + cwk.getKxh() + ",sjjxgzl=" + NumberUtils.decimalwithtwo(sjjxgzl));
                    //cwk.setKclx3("实习（实训）");
                }
            }else{
                cwk.setErrmsg(cwk.getErrmsg() +  "," + cwk.getKcm() + "备注(实习实训类型)数据不合法;");
            }
        }else{
            //普通课
            cwk.setKcxs(1.0f);
            cwk.setKclx3("普通课");
            cwk.setBz("普通课");
        }
        //是否专业核心课
        if(cwk.getSfcxk()==1){
            cwk.setKcxs(1.2f);
            cwk.setKclx3("专业核心课");
            cwk.setBz("专业核心课");
        }

        String kclx1 = cwk.getKclx1();
        kclx1 = StringUtils.chinese(kclx1);
        if(kclx1.contains("双语课")){
            cwk.setKcxs(1.2f);
            cwk.setKclx3("双语课");
            cwk.setBz("双语课");
        }
        /*网络自主学习课是
        else if(kclx1.contains("网络自主学习课")){
            cwk.setKcxs(0.4f);
            cwk.setKclx3("网络自主学习课");
            cwk.setBz("网络自主学习课");
        }
        */
        //（2）人数系数
        cwk.setRsxs(RatioStuNumber.ratio(cwk.getKclx2(),cwk.getXkrs()));
        //（3）计算授课学时工作量
        //理论教学工作量
        //除了集中实践课以外的其它课程
        if(!"集中实践课".equals(cwk.getKclx3())){
            float lljxgzl = cwk.getSkxs()*cwk.getRsxs()*cwk.getKcxs();
            cwk.setLljxgzl(NumberUtils.decimalwithtwo(lljxgzl));
        }else{
            //集中实践课的体系是1
            cwk.setRsxs(1.0f);
            cwk.setKcxs(1.0f);
        }
        return cwk;
    }

    //学分
    private Curworkload getXf(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        float sf =  StringUtils.str2float(str);
        curworkload.setXf(sf);
        if(sf<=0){
            curworkload.setErrmsg(curworkload.getErrmsg()+"学分数数据不合法;");
            curworkload.setXf(0.0f);
        }
        return  curworkload;
    }

    //校验学时
    private Curworkload jyxs(Curworkload cwl){
        //System.out.println(cwl.getKcm() + "," + cwl.getZxs() + "=" + cwl.getSkxs() + "+" + cwl.getSjxs() + "+" + cwl.getSyxs());
        int zxs = cwl.getZxs();
        int addzxs = cwl.getSkxs()+cwl.getSjxs()+cwl.getSyxs();
        //System.out.println(cwl.getKcm() + ",总学时=" + zxs + ",累计后的学时=" + addzxs);
        if(zxs!=addzxs){
            cwl.setErrmsg(cwl.getErrmsg()+"总学时!=授课学时+上机学时+实验学时;");
        }
        cwl.setZxs(cwl.getSkxs()+cwl.getSjxs()+cwl.getSyxs());
        return  cwl;
    }
    //实验学时
    private Curworkload getSyxs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int syxs = StringUtils.str2int(str);
        curworkload.setSyxs(syxs);
        if(syxs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"实验学时数数据不合法;");
            curworkload.setSyxs(0);
        }
        return curworkload;
    }

    //上机学时
    private Curworkload getSjxs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int sjxs = StringUtils.str2int(str);
        curworkload.setSjxs(sjxs);
        if(sjxs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"上机学时数数据不合法;");
            curworkload.setSjxs(0);
        }
        return curworkload;
    }


    //授课学时
    private Curworkload getSkxs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int skxs = StringUtils.str2int(str);
        curworkload.setSkxs(skxs);
        if(skxs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"授课学时数数据不合法;");
            curworkload.setSkxs(0);
        }
        return curworkload;
    }

    //总学时
    private Curworkload getZxs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int zxs = StringUtils.str2int(str);
        curworkload.setZxs(zxs);
        if(zxs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"总学时数数据不合法;");
            curworkload.setZxs(0);
        }
        return curworkload;
    }

    //处理学期
    private Curworkload getXq(String str, Map<String, Term> termMap, Curworkload workload){
        if(termMap.containsKey(str)){
            Term term = termMap.get(str);
            workload.setXq(term.getTermid());
            workload.setTerm(term);
        }else{
            workload.setErrmsg(workload.getErrmsg()+"，"+str+"学期数据不合法;");
        }
        return workload;
    }

    //处理学院
    private Curworkload getXy(String str, Map<String, College> collegeMapMap, Curworkload workload){
        if(collegeMapMap.containsKey(str)){
            College college = collegeMapMap.get(str);
            workload.setYxid(college.getCollid());
            workload.setCollege(college);
        }else{
            workload.setErrmsg(workload.getErrmsg()+"学院数据不合法;");
        }
        return workload;
    }

    //实际选课人数
    private Curworkload getXkrs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int xkrs = StringUtils.str2int(str);
        curworkload.setXkrs(xkrs);
        if(xkrs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"选课人数数据不合法;");
            curworkload.setXkrs(0);
        }
        return curworkload;
    }
    //实验课程校验
    //实验课程数据查询
    @RequestMapping(value = "/checksycourse")
    @ResponseBody
    public Datagrid<SyworkloadVO> findSyworkloadVO(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int rows,
            @RequestParam(value = "term",required = false,defaultValue = "0") Integer xq,
            @RequestParam(value = "department", required = false,defaultValue = "0")Integer xyid,
            @RequestParam(value = "kch", required = false,defaultValue = "")String kch,
            @RequestParam(value = "kxh", required = false,defaultValue = "")String kxh,HttpSession session){
        //将数据封装为前端datagrid能显示的数据结构
        Datagrid<SyworkloadVO> dg = new Datagrid<SyworkloadVO>();
        //数据分页查询
        PageInfo<SyworkloadVO> pageinfo =
                syworkloadService.findSyworkloadsByPage(page,rows,xq,(int)session.getAttribute("xyid"),kch,kxh);
        dg.setTotal(pageinfo.getTotal());
        dg.setRows(pageinfo.getList());

        for (int i=0;i<rows;i++){


            //getFpcx(Integer.toString((dg.getRows().get(i).getFpcx())),dg.getRows().get(i));//实验批次
            System.out.println(dg.getRows().get(i).getFpcx()+"*****"+getFpcx(Integer.toString((dg.getRows().get(i).getFpcx())),dg.getRows().get(i)).getFpcx());
            if (dg.getRows().get(i).getFpcx()!= getFpcx(Integer.toString((dg.getRows().get(i).getFpcx())),dg.getRows().get(i)).getFpcx()){
                dg.getRows().get(i).setErrmsg(getFpcx(Integer.toString((dg.getRows().get(i).getFpcx())),dg.getRows().get(i)).getErrmsg());
            }
            System.out.println(dg.getRows().get(i).getFpxs()+"&&&&"+getFpxs(Integer.toString((dg.getRows().get(i).getFpxs())),dg.getRows().get(i)).getFpxs());
            // getFpxs(Integer.toString((dg.getRows().get(i).getFpxs())),dg.getRows().get(i));//实验分批学时
            if (dg.getRows().get(i).getFpxs()!=getFpxs(Integer.toString((dg.getRows().get(i).getFpxs())),dg.getRows().get(i)).getFpxs()){
                dg.getRows().get(i).setErrmsg(getFpxs(Integer.toString((dg.getRows().get(i).getFpxs())),dg.getRows().get(i)).getErrmsg());
            }

            // fpcsygzltotal(dg.getRows().get(i));//当前实验工作量统计
            System.out.println(1);
            //System.out.println(fpcsygzltotal(dg.getRows().get(i)).getFpgzl()+"***");
//            if (dg.getRows().get(i).getFpgzl()!=fpcsygzltotal(dg.getRows().get(i)).getFpgzl()){
//                System.out.println(2);
//                dg.getRows().get(i).setErrmsg("分批工作量"+fpcsygzltotal(dg.getRows().get(i)).getFpgzl());
//
//            }
            System.out.println(dg.getRows().get(i).toString());


           // syfzgzl(dg.getRows().get(i));  //实验辅助工作量计算

//            c1(dg.getRows().get(i));//实验辅助工作量C1系数
//            k1(dg.getRows().get(i).getXkrs());//指导实验工作量k1系数
//            k2(dg.getRows().get(i).getXkrs());  //指导实验工作量k2系数
        }
        return dg;
    }
    //分批次实验学时累计
    private static void xscalcuate(Syworkload cwk, Map<String,KcsyxsComparator> comparatorMap){
        String key = cwk.getXq()+cwk.getKch()+cwk.getKxh();
        if(comparatorMap.containsKey(key)){
            KcsyxsComparator comparator = comparatorMap.get(key);
            comparator.setFpxs(comparator.getFpxs()+cwk.getFpxs());
        }else{
            KcsyxsComparator comparator = new KcsyxsComparator();
            comparator.setSjxstotal(cwk.getCwl().getSyxs()+cwk.getCwl().getSjxs());
            comparator.setFpxs(comparator.getFpxs()+cwk.getFpxs());
            comparator.setSwl(cwk);
            comparatorMap.put(cwk.getXq()+cwk.getKch()+cwk.getKxh(),comparator);

        }
    }

    //实验批次
    private SyworkloadVO getFpcx(String str,SyworkloadVO curworkload){
        str = StringUtils.trim(str);
        int pc = StringUtils.str2int(str);
        curworkload.setFpcx(pc);
        if(pc==-1){
            curworkload.setErrmsg(curworkload.getErrmsg()+"实验分批次数不合法;");
            curworkload.setFpcx(0);
        }
        return curworkload;
    }

    //实验分批学时
    private SyworkloadVO getFpxs(String str,SyworkloadVO curworkload){
        str = StringUtils.trim(str);
        int fpxs = StringUtils.str2int(str);
        curworkload.setFpxs(fpxs);
        if(fpxs==-1){
            curworkload.setErrmsg(curworkload.getErrmsg()+"分批学时数数据不合法;");
            curworkload.setFpxs(0);
        }
        return curworkload;
    }

    //处理学期
    private static void getXq(String str,Map<String,Term> termMap,SyworkloadVO workload){
        if(termMap.containsKey(str)){
            Term term = termMap.get(str);
            workload.setXq(term.getTermid());
        }else{
            workload.setErrmsg(workload.getErrmsg()+"学期数据不合法;");
        }
    }

    //当前实验工作量统计
    /**
     *
     * @param swl:当前实验的信息
     */
    public SyworkloadVO fpcsygzltotal(SyworkloadVO swl){
        int fpcs = swl.getFpcx();//分成几批完成实验
        int fpxs = swl.getFpxs();//每批次的学时数
        int xsrs = swl.getCwl().getXkrs();//总共选修的学生人数
        //每一个分组的平均人数
        int[] R = new int[fpcs];
        int num = 0;
        for(int i=0;i<fpcs;i++){
            R[i] = xsrs/fpcs;
            num+=R[i];
        }
        R[R.length-1] += (xsrs-num);
        //指导实验工作量计算
        float zdsygzl = 0.0f;
        for(int i=0;i<fpcs;i++){
            zdsygzl+=fpxs*(1+k1(R[i]))*k2(R[i]);
        }
        //实验辅助工作量
        float fzgzl = syfzgzl(swl);
        //当前实验工作量统计=指导实验工作量+实验辅助工作量
        swl.setFpgzl(zdsygzl+fzgzl);
        return swl;
    }

    //实验辅助工作量计算
    private static float syfzgzl(SyworkloadVO swl){
        float gzl = 0.0f;
        //H—为实验计划学时数,即分配学时数
        int H = swl.getFpxs();
        //C1—实验批次系数
        float C = c1(swl);
        gzl = H*C;
        return gzl;
    }

    //实验辅助工作量C1系数
    private static float c1(SyworkloadVO swl){
        float c = 0;
        String kclx1 = StringUtils.chinese(swl.getCwl().getKclx1());
        if("计算机公共基础课".equals(kclx1)){
            c = 0.05f;
        }else{
            int pfcx = swl.getFpcx();
            if(pfcx==1) {
                c = 0.15f;
            }else if(pfcx==2){
                c = 0.2f;
            }else if(pfcx==3){
                c = 0.25f;
            }else c = 0.3f;
        }
        return c;
    }

    //指导实验工作量k1系数
    private static float k1(int r){
        float ki = 0.0f;
        if(r>50){
            ki = (r-50)*0.01f;
        }
        return ki;
    }

    //指导实验工作量k2系数
    private static float k2(int stunum){
        float r = 1.0f;
        if(stunum<6){
            r = 0.5f;
        }else if(stunum<=15){
            r = 0.6f;
        }else if(stunum<=25){
            r = 0.8f;
        }
        return r;
    }

}
