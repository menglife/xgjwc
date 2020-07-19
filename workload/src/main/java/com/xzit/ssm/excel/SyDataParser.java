package com.xzit.ssm.excel;

import com.xzit.ssm.entity.College;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.Syworkload;
import com.xzit.ssm.entity.Term;
import com.xzit.ssm.service.WorkloadService;
import com.xzit.ssm.vo.KcsyxsComparator;
import com.xzit.ssm.vo.RatioStuNumber;
import com.xzit.ssm.vo.Trainee;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by hjx on 2018/11/5 0005
 */
public class SyDataParser {
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

    //将web容器中存放在ServletContext中的学院List转换为Map
    public static Map<String,College> getCollegeMap(HttpServletRequest request){
        ServletContext context = request.getServletContext();
        List<College> colleges =  (List<College>) context.getAttribute("colleges");
        Map<String,College> termMap = new HashMap<>();
        for(College college:colleges){
            termMap.put(college.getName(),college);
        }
        return termMap;
    }

    //解析分批实验课数据
    /**
     *
     * @param termMap   学期情况
     * @param datas     解析的主要数据，包括：学期，课程号，课序，课程名，分批次数，每批次学时
     * @param errorData
     * @param validData
     */
    public static void parserSykc(
            Map<String,Term> termMap,
            List<String[]> datas,        //解析的主要数据
            List<Syworkload> errorData,
            List<Syworkload> validData,
            WorkloadService workloadService,
            List<String[]> syDatas
    ){
        Map<String,KcsyxsComparator> comparatorMap = new HashMap<>();
        for(int i=0;i<datas.size();i++) {

            //解析后的数据需要封装为Syworkload对象
            Syworkload workload = new Syworkload();
            String[] rowdata = datas.get(i);
            //第0个数据是学期
            //dataWithMsg比rowdata多一列
            String[] dataWithMsg = new String[rowdata.length+1];
            //先将rowdata数组的值拷贝到dataWithMsg数组中
            System.arraycopy(rowdata,0,dataWithMsg,0,rowdata.length);

            String xqstr = rowdata[0];//第0个数据是学期
            getXq(xqstr,termMap,workload);
            workload.setKch(StringUtils.trim(rowdata[1]));    //第1个数据是课程号
            workload.setKxh(StringUtils.trim(rowdata[2]));    //第2个数据是课序号
            //第7个数据是批次
            getFpcx(rowdata[7],workload);
            //第8个数据是批次对应的学时
            getFpxs(rowdata[8],workload);
            //根据xq,kch,kxh查找课程信息是否存在
            Curworkload cwl = workloadService.find(workload.getXq(),workload.getKxh(),workload.getKch());
            //如果课程信息不存在，则数据不合法
            if(cwl==null){
                workload.setErrmsg(workload.getErrmsg()+",当前课程信息在理论课程总表中不存在;");
            }else{
                workload.setCwl(cwl);
                workload.setSyzxs(cwl.getSyxs()+cwl.getSjxs());
                workload.setXyid(cwl.getYxid());
                //将对象以xq+kch+kxh为key放置到map中，看是否该课程号对应的总学时是否正确
                //xscalcuate(workload,comparatorMap); 此处不处理，改由数据校验来完成
            }
            //将解析后是否有问题的信息保存到dataWithMsg最后一列
            dataWithMsg[dataWithMsg.length-1] = workload.getErrmsg();
            syDatas.add(dataWithMsg);

            if("".equals(workload.getErrmsg())){
                //计算工作量
                //非网络自主学习课程实验工作量计算
                String kclx1 = cwl.getKclx1();
                if(!"网络自主学习课".equals(kclx1)){
                    fpcsygzltotal(workload);
                }else{
                    //网络自主学习课实验=实验学时*0.4
                    workload.setFpgzl(workload.getSyzxs()*0.4f);
                }

                validData.add(workload);
            }else{
                errorData.add(workload);
            }
        }
    }

    //分批次实验学时累计
    private static void xscalcuate(Syworkload cwk,Map<String,KcsyxsComparator> comparatorMap){
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
    private static void getFpcx(String str,Syworkload curworkload){
        str = StringUtils.trim(str);
        int pc = StringUtils.str2int(str);
        curworkload.setFpcx(pc);
        if(pc==-1){
            curworkload.setErrmsg(curworkload.getErrmsg()+"实验分批次数不合法;");
            curworkload.setFpcx(0);
        }
    }

    //实验分批学时
    private static void getFpxs(String str,Syworkload curworkload){
        str = StringUtils.trim(str);
        int fpxs = StringUtils.str2int(str);
        curworkload.setFpxs(fpxs);
        if(fpxs==-1){
            curworkload.setErrmsg(curworkload.getErrmsg()+"分批学时数数据不合法;");
            curworkload.setFpxs(0);
        }
    }

    //处理学期
    private static void getXq(String str,Map<String,Term> termMap,Syworkload workload){
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
    public static void fpcsygzltotal(Syworkload swl){
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
    }

    //实验辅助工作量计算
    private static float syfzgzl(Syworkload swl){
        float gzl = 0.0f;
        //H—为实验计划学时数,即分配学时数
        int H = swl.getFpxs();
        //C1—实验批次系数
        float C = c1(swl);
        gzl = H*C;
        return gzl;
    }

    //实验辅助工作量C1系数
    private static float c1(Syworkload swl){
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
