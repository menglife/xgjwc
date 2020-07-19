package com.xzit.ssm.service;

import com.xzit.ssm.entity.User;
import com.xzit.ssm.entity.UserExample;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface UserService {
    public void updataUser(User user, UserExample userExample);
    User selectByName(String name);

    @RequestMapping(value = "logindata",method = RequestMethod.POST)
    ModelAndView login(@RequestParam("username") String name, @RequestParam("password") String password, HttpServletRequest request, HttpSession session);
}
