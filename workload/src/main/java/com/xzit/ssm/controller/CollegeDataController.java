package com.xzit.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.CurworkloadExample;
import com.xzit.ssm.entity.Syworkload;
import com.xzit.ssm.entity.SyworkloadExample;
import com.xzit.ssm.service.SyworkloadService;
import com.xzit.ssm.service.WorkloadService;
import com.xzit.ssm.vo.Datagrid;
import com.xzit.ssm.vo.SyworkloadVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CollegeDataController {

    @Autowired
    SyworkloadService syworkloadService;
    @Autowired
    WorkloadService workloadService;
    @Autowired

    @RequestMapping(value = "collegesy")
    public String collegesy(){
        return "findsycourse";
    }
//   理论教学工作量校验Q=VKR
    @RequestMapping(value = "coursecheck",method = RequestMethod.POST)
    @ResponseBody
    public  Datagrid<Curworkload> coursecheck(     @RequestParam(defaultValue = "1") int page,
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
        System.out.println((int)session.getAttribute("rows"));

        for(int j=0;j<(int)session.getAttribute("rows");j++){
            float f=(int)((dg.getRows().get(j).getSkxs()*dg.getRows().get(j).getKcxs()*dg.getRows().get(j).getRsxs())*1000);
            boolean p=f/1000==dg.getRows().get(j).getLljxgzl();
            float fz=(int)(dg.getRows().get(j).getSumgzl()*1000);
            float fs=dg.getRows().get(j).getSjjxgzl()+f/1000; //理论+实践工作量
            float fs2=Math.round(fs*100);
            boolean p1=fs2/100==(float) fz/1000;
            if (p&&p1){  //前提保证理论实验均正确
                String s="T";
                dg.getRows().get(j).setCwd(s);
                if (dg.getRows().get(j).getCwd()=="T"){
                    dg.getRows().get(j).setJy(" ");
                }

            }else {
                String s="F";
                dg.getRows().get(j).setCwd(s);
                dg.getRows().get(j).setJy(" ");
                Curworkload curworkload=new Curworkload();
                curworkload.setId(dg.getRows().get(j).getId());
                curworkload.setCwd(s);
                workloadService.updatacwd(curworkload);


            }
        }
        return dg ;
    }
    @RequestMapping(value = "/findcoursegzlByid")
    public ModelAndView findcoursegzlByid(int id){
        ModelAndView modelAndView=new ModelAndView();
        Curworkload curworkload=workloadService.findByPrimaryKey(id);
        modelAndView.addObject("curworkload",curworkload);

        modelAndView.setViewName("courseedit");
        return modelAndView;
    }
    @RequestMapping(value = "findsycoursegzlByid")
    public ModelAndView findsycoursegzlByid(int id){
        ModelAndView modelAndView=new ModelAndView();
        Syworkload syworkload=syworkloadService.selectByPrimaryKey(id);

        modelAndView.addObject("syworkload",syworkload);

        modelAndView.setViewName("syedit");
        return modelAndView;
    }
    @RequestMapping(value = "/deletecourse",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deletecourse(int id){
        Map<String,Object> resultMap=new HashMap<String, Object>();

        workloadService.deleteByPrimaryKey(id);
        resultMap.put("success",true);
        resultMap.put("mag","删除成功");
        return  resultMap;
    }
    //更新理论
    @RequestMapping(value = "/updatacourse",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updatacourse( HttpSession session, Curworkload curworkload){
        Map<String,Object> resultMap=new HashMap<String, Object>();
//        if (curworkload.getSyxs()==0){
//            curworkload.setSkxs(curworkload.getZxs());
//        }

        CurworkloadExample curworkloadExample=new CurworkloadExample();
        CurworkloadExample.Criteria criteria= curworkloadExample.createCriteria();
        criteria.andIdEqualTo(curworkload.getId());

        if (curworkload.getId()!=null&&curworkload.getId()>0){

           workloadService.updateByExample(curworkload,curworkloadExample);
            resultMap.put("success",true);
            resultMap.put("msg","更新成功");
        }
        return resultMap;
    }
    //更新实验
    @RequestMapping(value = "/syupdatasycourse",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> syupdatasycourse( HttpSession session, Syworkload syworkload){
        Map<String,Object> resultMap=new HashMap<String, Object>();
        SyworkloadExample syworkloadExample=new SyworkloadExample();
        SyworkloadExample.Criteria criteria=syworkloadExample.createCriteria();
        criteria.andSyidEqualTo(syworkload.getSyid());
        if (syworkload.getSyid()!=null&&syworkload.getSyid()>0){
            syworkloadService.updateByExample(syworkload,syworkloadExample);
            resultMap.put("success",true);
            resultMap.put("msg","更新成功");
        }
        return resultMap;


    }
    @RequestMapping(value = "/deletesycourse",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deletesycourse(int id){
        Map<String,Object> resultMap=new HashMap<String, Object>();

        syworkloadService.deleteByPrimaryKey(id);
        resultMap.put("success",true);
        resultMap.put("mag","删除成功");
        return  resultMap;
    }
    @RequestMapping(value = "/sycheck")
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
       
        for (int j=0;j<(int)session.getAttribute("rows");j++){
            float k2=0.00f; //每批次实验人数系数          ;
            if (6<=dg.getRows().get(j).getXkrs()&&dg.getRows().get(j).getXkrs()<=15){
                k2=(float) 0.6;
            }else if (15<dg.getRows().get(j).getXkrs()&&dg.getRows().get(j).getXkrs()<=25){
                k2=(float)0.8;
            }else if (dg.getRows().get(j).getXkrs()>25){
                k2=(float)1;
            }
            float k1=(float) ((dg.getRows().get(j).getXkrs()-50)*0.01);
           boolean p= (1+k1)*k2*dg.getRows().get(j).getSyxs()==dg.getRows().get(j).getFpgzl();
           if (p){
               String s="Y";
               dg.getRows().get(j).setCwd(s);
           }

        }
        return dg;
    }

}
