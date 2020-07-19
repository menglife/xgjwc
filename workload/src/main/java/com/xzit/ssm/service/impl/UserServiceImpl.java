package com.xzit.ssm.service.impl;

import com.xzit.ssm.controller.LoginController;
import com.xzit.ssm.entity.User;
import com.xzit.ssm.entity.UserExample;
import com.xzit.ssm.mapper.UserMapper;
import com.xzit.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    UserMapper userMapper;

    @Override
    public void updataUser(User user, UserExample userExample) {
        userMapper.updateByExampleSelective(user,userExample);
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    @RequestMapping(value = "logindata",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String name, @RequestParam("password") String password, HttpServletRequest request, HttpSession session){
        String r= request.getParameter("username");


        ModelAndView modelAndView=new ModelAndView();
        User u= selectByName(name);
        if (u.getPassword().equals(password)){
//            LoginController.s=
            session.setAttribute("xyid", u.getCollegeid());
        }else {
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if (r.equals("jwc")){
            User user= selectByName(name);
            modelAndView.addObject("user",user);
            modelAndView.setViewName("main");
            return modelAndView;
        }else {
            User user= selectByName(name);
            modelAndView.addObject("user",user);
            modelAndView.setViewName("collegeindex");
            return modelAndView;
        }

    }
}
