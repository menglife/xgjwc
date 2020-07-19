package com.xzit.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Otherworkload;
import com.xzit.ssm.service.OtherworkloadService;
import com.xzit.ssm.vo.Datagrid;
import com.xzit.ssm.vo.OtherworkloadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * create by hjx on 2018/11/28 0028
 */
@Controller
public class OthergzlController {
    @Autowired
    private OtherworkloadService otherworkloadService;



    //其它工作量数据查询
    @RequestMapping(value = "/findotherwl")
    @ResponseBody
    public Datagrid<OtherworkloadVO> findSyworkloadVO(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int rows,
            @RequestParam(value = "term",required = false,defaultValue = "0") Integer xq,
            @RequestParam(value = "department", required = false,defaultValue = "0")Integer xyid){
        //将数据封装为前端datagrid能显示的数据结构
        Datagrid<OtherworkloadVO> dg = new Datagrid<OtherworkloadVO>();
        //数据分页查询
        PageInfo<OtherworkloadVO> pageinfo =
                otherworkloadService.findPageByTermidAndCollid(page,rows,xq,xyid);
        dg.setTotal(pageinfo.getTotal());
        dg.setRows(pageinfo.getList());
        return dg;
    }

    //其它工作量添加/新增
    @RequestMapping(value = "/updateotherwl")
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
    @RequestMapping(value = "/deleteotherwl")
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
    @RequestMapping(value = "/findOthergzlByid")
    public ModelAndView findOthergzlByid(int otherid){
        ModelAndView mv = new ModelAndView();
        Otherworkload otherwl = otherworkloadService.findById(otherid);
        mv.addObject("otherwl",otherwl);
        mv.setViewName("othergzledit");
        return mv;
    }

    @RequestMapping(value = "/deleteall")
    @ResponseBody
    public Map<String,Object> deleteAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        map.put("msg","其它工作量清理成功。");
        otherworkloadService.deleteAll();
        return map;
    }



}
