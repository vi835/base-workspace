package com.valo;

import com.valo.Service.SomeService;
import com.valo.Service.impl.SomeServiceImpl;
import com.valo.handler.MyInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 调用doSome doOther
//        SomeService someService = new SomeServiceImpl();
//        someService.doSome();
//        System.out.println("==========================");
//        someService.doOther();

        // 使用jdk的Proxy创建代理对象
        // 创建目标对象
        SomeService target = new SomeServiceImpl();

        // 创建InvocationHandler对象
        InvocationHandler handler = new MyInvocationHandler(target);

        // 使用Proxy创建代理
        SomeService proxy= (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);

        // 通过代理执行方法 会调用handler中invoke()
        proxy.doSome();
        System.out.println("=======================");
        proxy.doOther();
    }
}
