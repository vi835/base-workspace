package com.valo;

import com.valo.domain.SysUser;
import com.valo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 从spring容器中获取userService类型的对象 dao,service都是spring管理的
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.addUser(new SysUser());
    }

}
