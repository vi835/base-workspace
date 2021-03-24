package com.valo.ba01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        try {
            SomeService someService = (SomeService) context.getBean("someServiceImpl");
            System.out.println(someService.getClass().getName());
            someService.doSome("11", 2);

            String str=someService.doOther("zs",20);
            System.out.println("str=====>"+str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));


    }
}
