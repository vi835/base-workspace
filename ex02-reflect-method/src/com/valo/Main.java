package com.valo;

import com.valo.service.HelloService;
import com.valo.service.impl.HelloServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HelloService service = new HelloServiceImpl();
        service.sayHello("张三");

        // 使用反射机制执行sayHello方法 核心Method方法(类中的方法)
        HelloService target=new HelloServiceImpl();
        // 获取sayHello名称对应的Method对象
        Method sayHello = HelloService.class.getMethod("sayHello",String.class);
        // 通过Method可以执行sayHello方法调用
        /*
        invoke是Method类中的一个方法 表示执行方法的调用
        参数: 1.Object 表示对象的 要执行这个对象的方法
             2.Object... args,方法执行时的参数值
        返回值: Object 方法执行后的返回值
         */
        Object result = sayHello.invoke(target, "李四");

    }
}
