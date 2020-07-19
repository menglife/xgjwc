package com.xzit.ssm.excel;

import com.xzit.ssm.entity.College;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.Syworkload;
import com.xzit.ssm.entity.Term;
import com.xzit.ssm.service.WorkloadService;
import com.xzit.ssm.vo.RatioStuNumber;
import com.xzit.ssm.vo.Trainee;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * create by hjx on 2018/11/5 0005
 */
public class DataParser {

    //哪些是更新的，哪些是新增的
    public static void divide(List<Curworkload> data,
                              WorkloadService ws,
                              List<Curworkload> insertList,
                              List<Curworkload> updateList){
          for(Curworkload cwl:data){
              if(ws.find(cwl.getXq(),cwl.getKxh(),cwl.getKch())!=null){
                  updateList.add(cwl);
              }else{
                  insertList.add(cwl);
              }
          }

    }

    /*将web容器中存放在ServletContext中的学期List转换为Map
     */
    public static Map<String,Term> getTermMap(HttpServletRequest request){
        ServletContext context = request.getServletContext();
        List<Term> terms =  (List<Term>) context.getAttribute("terms");
        Map<String,Term> termMap = new HashMap<>();
        for(Term term:terms){
            termMap.put(term.getTermname(),term);
        }
        return termMap;
    }

    //将web容器中存放在ServletContext中的学期List转换为Map
    public static Map<String,College> getCollegeMap(HttpServletRequest request){
        ServletContext context = request.getServletContext();
        List<College> colleges =  (List<College>) context.getAttribute("colleges");
        Map<String,College> termMap = new HashMap<>();
        for(College college:colleges){
            termMap.put(college.getName(),college);
        }
        return termMap;
    }

    /**
     * 解析课程数据
     * @param termMap:学期数据
     * @param collegeMap：学院数据
     * @param datas：待解析的数据
     * @param errorData:解析中不合法的数据集
     * @param validData：合法的数据集
     */
    public static void parser(
            Map<String,Term> termMap,
            Map<String,College> collegeMap,
            List<String[]> datas,
            List<Curworkload> errorData,
            List<Curworkload> validData,
            List<Curworkload> cwlDatas){
        //List<Curworkload> workloads = new ArrayList<Curworkload>();
        for(int i=0;i<datas.size();i++){
            //解析后的数据需要封装为Curworkload对象
            Curworkload workload = new Curworkload();
            String[] rowdata = datas.get(i);
            //System.out.println("-------------------------------------------");
            //for(int k=0;k<rowdata.length;k++)
            //System.out.print(rowdata[0]+","+rowdata[1]);
            //System.out.println("-------------------------------------------");
            //第0个数据是学期
            String xqstr = StringUtils.trim(rowdata[0]);
            getXq(xqstr,termMap,workload);  //学期
            workload.setKch(StringUtils.trim(rowdata[1]));    //课程号
            workload.setKxh(StringUtils.trim(rowdata[2]));    //课序号
            workload.setKcm(StringUtils.trim(rowdata[3]));   //课程名
            workload.setSkls(StringUtils.trim(rowdata[4]));  //授课教师
            workload.setLszc(StringUtils.trim(rowdata[5]));  //老师职称
            getXy(StringUtils.trim(rowdata[6]),collegeMap,workload);  //所属学院
            workload.setKcsx(rowdata[7]); //课程属性
            workload.setBjmc(rowdata[8]); //班级名称
            //workload.setKrl(StringUtils.str2int(rowdata[9]));//课容量
            getXkrs(rowdata[9],workload);//实际选课人数
            getZxs(rowdata[10],workload);//总学时
            //workload.setMzxs(StringUtils.str2int(rowdata[12]));//每周学时
            getSkxs(rowdata[11],workload);//授课学时
            getSjxs(rowdata[12],workload);//上机学时
            getSyxs(rowdata[13],workload);//实验学时
            getXf(rowdata[14],workload);//学分
            workload.setKclx(StringUtils.trim(rowdata[15]));//课程类型
            //是否是核心课程
            workload.setSfcxk("是".equals(StringUtils.trim(rowdata[16]))?1:0);
            workload.setBz(StringUtils.trim(rowdata[17]));//备注
            workload.setKclx1(StringUtils.trim(rowdata[18])); //课程类型1
            workload.setKclx2(StringUtils.trim(rowdata[19])); //课程类型2

            //数据计算
            xscalcuate(workload);

            //校验：总学时=授课学时+上机学时+实验学时
            //jyxs(workload);

            cwlDatas.add(workload);
            if("".equals(workload.getErrmsg())){
                validData.add(workload);
            }else{
                errorData.add(workload);
            }
        }
    }

    //是否有重复的元素存在
    public static void duplicateWorkload(List<Curworkload> duplicateData,
                                  List<Curworkload> validData){
          Map<String,Curworkload> map = new HashMap<String,Curworkload>();
          for(Curworkload cwl:validData){
              String key = cwl.getXq()+cwl.getKch()+cwl.getKxh();
              if(map.containsKey(key)){
                  cwl.setErrmsg(cwl.getErrmsg() +  "," + "开课学年/课程号/课序号有重复的数据");
                  duplicateData.add(cwl);
                  duplicateData.add(map.get(key));
              }else {
                  map.put(key, cwl);
              }
          }
    }

    //学时计算
    public static void xscalcuate(Curworkload cwk){
        //（1）课程系数
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
    }

    //学分
    private static void getXf(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        float sf =  StringUtils.str2float(str);
        curworkload.setXf(sf);
        if(sf<=0){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"学分数数据不合法;");
            curworkload.setXf(0.0f);
        }
    }

    //校验学时
    private static void jyxs(Curworkload cwl){
         //System.out.println(cwl.getKcm() + "," + cwl.getZxs() + "=" + cwl.getSkxs() + "+" + cwl.getSjxs() + "+" + cwl.getSyxs());
        int zxs = cwl.getZxs();
        int addzxs = cwl.getSkxs()+cwl.getSjxs()+cwl.getSyxs();
        //System.out.println(cwl.getKcm() + ",总学时=" + zxs + ",累计后的学时=" + addzxs);
        if(zxs!=addzxs){
             cwl.setErrmsg(cwl.getErrmsg()+"总学时!=授课学时+上机学时+实验学时;");
         }
    }
    //实验学时
    private static void getSyxs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int syxs = StringUtils.str2int(str);
        curworkload.setSyxs(syxs);
        if(syxs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"实验学时数数据不合法;");
            curworkload.setSyxs(0);
        }
    }

    //上机学时
    private static void getSjxs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int sjxs = StringUtils.str2int(str);
        curworkload.setSjxs(sjxs);
        if(sjxs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"上机学时数数据不合法;");
            curworkload.setSjxs(0);
        }
    }


    //授课学时
    private static void getSkxs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int skxs = StringUtils.str2int(str);
        curworkload.setSkxs(skxs);
        if(skxs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"授课学时数数据不合法;");
            curworkload.setSkxs(0);
        }
    }

    //总学时
    private static void getZxs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int zxs = StringUtils.str2int(str);
        curworkload.setZxs(zxs);
        if(zxs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"总学时数数据不合法;");
            curworkload.setZxs(0);
        }
    }

    //处理学期
    private static void getXq(String str,Map<String,Term> termMap,Curworkload workload){
          if(termMap.containsKey(str)){
              Term term = termMap.get(str);
              workload.setXq(term.getTermid());
              workload.setTerm(term);
          }else{
              workload.setErrmsg(workload.getErrmsg()+"，"+str+"学期数据不合法;");
          }
    }

    //处理学院
    private static void getXy(String str,Map<String,College> collegeMapMap,Curworkload workload){
        if(collegeMapMap.containsKey(str)){
            College college = collegeMapMap.get(str);
            workload.setYxid(college.getCollid());
            workload.setCollege(college);
        }else{
            workload.setErrmsg(workload.getErrmsg()+"学院数据不合法;");
        }
    }

    //实际选课人数
    private static void getXkrs(String str,Curworkload curworkload){
        str = StringUtils.trim(str);
        int xkrs = StringUtils.str2int(str);
        curworkload.setXkrs(xkrs);
        if(xkrs==-1){
            //curworkload.setErrmsg(curworkload.getErrmsg()+"选课人数数据不合法;");
            curworkload.setXkrs(0);
        }
    }

}
