package com.xzit.ssm.listener;

import com.xzit.ssm.entity.College;
import com.xzit.ssm.entity.Term;
import com.xzit.ssm.service.CollegeService;
import com.xzit.ssm.service.TermService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sound.midi.SoundbankResource;
import java.util.List;

/**
 * create by hjx on 2018/11/5 0005
 */
public class WebContainerListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("contextInitialized....");
        //把一些固定不变的一些信息查询出来放在application里
        //调用service来完成查询
        //如何获取springmvc容器中的bean
        WebApplicationContext springContext =
             WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        //System.out.println("springContext:" + springContext);
        TermService termService = (TermService)springContext.getBean("termService");
        //System.out.println("termService:" + termService);
        List<Term> terms = termService.findAllTerms();
        //保存在一个application
        event.getServletContext().setAttribute("terms",terms);
        //学院Service
        CollegeService collegeService = (CollegeService)springContext.getBean("collegeService");
        List<College> colleges =  collegeService.findAll();
        event.getServletContext().setAttribute("colleges",colleges);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed....");
    }
}
