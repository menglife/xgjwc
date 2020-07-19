package com.xzit.ssm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        applicationContext.getBean("student",Student.class);
    }
}
