package com.xzit.ssm.controller;

import com.xzit.ssm.entity.Term;
import com.xzit.ssm.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * create by hjx on 2018/11/5 0005
 */
@Controller
public class CommonController {
    //注入Service组件
    @Autowired
    private TermService termService;

    //查询学期信息
    public List<Term> findTerms(HttpServletRequest request){
        //先从ServletContext上下文(application)中查询terms是否存在
        ServletContext context = request.getServletContext();
        List<Term> terms = (List<Term>)context.getAttribute("terms");
        if(terms==null){
            //service组件完成查询
            terms = termService.findAllTerms();
            context.setAttribute("terms",terms);
        }
        return terms;
    }
}
