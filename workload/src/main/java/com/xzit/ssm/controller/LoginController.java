package com.xzit.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Otherworkload;
import com.xzit.ssm.entity.User;
import com.xzit.ssm.entity.UserExample;
import com.xzit.ssm.service.OtherworkloadService;
import com.xzit.ssm.service.SyworkloadService;
import com.xzit.ssm.service.UserService;
import com.xzit.ssm.service.WorkloadService;
import com.xzit.ssm.vo.Datagrid;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.vo.OtherworkloadVO;
import com.xzit.ssm.vo.SyworkloadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    static int s;
    @Autowired
    UserService userService;
    @Autowired
    SyworkloadService syworkloadService;
    @Autowired
    WorkloadService workloadService;
    @Autowired
    OtherworkloadService otherworkloadService;
    //用户登录
    @RequestMapping(value = "loginpage")
    public  String loginpage(){
        return "login";
    }
    @RequestMapping(value = "coursedataindex")
    public String coursedataindex(){
        return "data/coursedata";
    }
    @RequestMapping(value = "otherdataindex")
    public String otherdataindex(){
        return "data/otherdata";
    }

    @RequestMapping(value ="/sydataindex",method = RequestMethod.GET)
    public String sjdataimport(){
        return "data/sydata";
    }
    //其它工作量窗口首页
    @RequestMapping(value ="/othergzlindex2",method = RequestMethod.GET)
    public String otherworkload(){
        return "data/othergzllist2";
    }

    //密码更改
    @RequestMapping(value = "updataInfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updataInfo(@RequestParam("username") String name,@RequestParam("password") String password){
        Map<String,Object> resultMap=new HashMap<String, Object>();
        System.out.println(name);
        User user=new User();
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andNameEqualTo(name);
        user.setPassword(password);
        userService.updataUser(user,userExample);
        User u=userService.selectByName(name);
        resultMap.put("code",0);
        resultMap.put("msg",u);
        return resultMap;
    }
    //数据查询
    @RequestMapping(value = "/coursedata")
    @ResponseBody
    public Datagrid<Curworkload> findcourses(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int rows,
            @RequestParam(value = "term",required = false,defaultValue = "0") Integer xq,
            @RequestParam(value = "department", required = false,defaultValue = "0")Integer xyid,
            @RequestParam(value = "coursetype", required = false,defaultValue = "") String coursetype,
            @RequestParam(value = "kcm", required = false,defaultValue = "") String kcm,
            @RequestParam(value = "skls", required = false,defaultValue = "") String skls,HttpSession session){
        //将数据封装为前端datagrid能显示的数据结构
        session.setAttribute("page",page);
        session.setAttribute("rows",rows);
        session.setAttribute("xq",xq);
        session.setAttribute("coursetype",coursetype);
        session.setAttribute("kcm",kcm);
        session.setAttribute("skls",skls);
        xyid=s;
        Datagrid<Curworkload> dg = new Datagrid<>();
        //数据分页查询
        PageInfo<Curworkload> pageinfo =
                workloadService.findCurworkloadsByPage(
                        page,rows,xq,xyid,coursetype,kcm,skls);

        dg.setTotal(pageinfo.getTotal());
        dg.setRows(pageinfo.getList());

//        dg.getRows().get(0).
//        for(int j=0;j<rows;j++){
//            if ((dg.getRows().get(j).getZxs()*dg.getRows().get(j).getKcxs()*dg.getRows().get(j).getRsxs()==dg.getRows().get(j).getSumgzl())){
//                System.out.println(dg.getRows().get(j).toString());
//                String s="Y";
//                dg.getRows().get(j).setCwd(s);
//            }
//
//        }


        return dg;
    }
    //实验课程数据查询
    @RequestMapping(value = "/sydata")
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
        xyid=s;
        PageInfo<SyworkloadVO> pageinfo =
                syworkloadService.findSyworkloadsByPage(page,rows,xq,xyid,kch,kxh);
        dg.setTotal(pageinfo.getTotal());
        dg.setRows(pageinfo.getList());
        return dg;
    }
    //其它工作量数据查询
    @RequestMapping(value = "/findotherwl2")
    @ResponseBody
    public Datagrid<OtherworkloadVO> findSyworkloadVO(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int rows,
            @RequestParam(value = "term",required = false,defaultValue = "0") Integer xq,
            @RequestParam(value = "department", required = false,defaultValue = "0")Integer xyid){
        //将数据封装为前端datagrid能显示的数据结构
        Datagrid<OtherworkloadVO> dg = new Datagrid<OtherworkloadVO>();
        //数据分页查询
        xyid=s;
        PageInfo<OtherworkloadVO> pageinfo =
                otherworkloadService.findPageByTermidAndCollid(page,rows,xq,xyid);
        dg.setTotal(pageinfo.getTotal());
        dg.setRows(pageinfo.getList());
        return dg;
    }

    //其它工作量添加/新增
    @RequestMapping(value = "/updateotherwl2")
    @ResponseBody
    public Map<String,Object> update(Otherworkload owl){
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        if(owl.getOtherid()!=null && owl.getOtherid()>0){
            otherworkloadService.update(owl);
            map.put("success",true);
            map.put("msg","其它工作量更新成功。");
        }else{
            otherworkloadService.insert(owl);
            map.put("success",true);
            map.put("msg","其它工作量添加成功。");
        }
        return map;
    }

    //其它工作量添加/新增
    @RequestMapping(value = "/deleteotherwl2")
    @ResponseBody
    public Map<String,Object> deleteotherwl(int otherid){
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        map.put("msg","其它工作量删除成功。");
        if(otherworkloadService.deleteById(otherid)>0){
            map.put("success",true);
            map.put("msg","其它工作量删除成功。");
        }
        return map;
    }

    //查询某条记录，并将查询结果存放在request范围中，返回到修改页面
    @RequestMapping(value = "/findOthergzlByid2")
    public ModelAndView findOthergzlByid(int otherid){
        ModelAndView mv = new ModelAndView();
        Otherworkload otherwl = otherworkloadService.findById(otherid);
        mv.addObject("otherwl",otherwl);
        mv.setViewName("othergzledit");
        return mv;
    }

    @RequestMapping(value = "/deleteall2")
    @ResponseBody
    public Map<String,Object> deleteAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        map.put("msg","其它工作量清理成功。");
        otherworkloadService.deleteAll();
        return map;
    }


}
