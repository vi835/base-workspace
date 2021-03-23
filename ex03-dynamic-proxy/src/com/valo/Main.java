package com.valo;

import com.valo.factory.UsbKingFactory;
import com.valo.handler.MySellHandler;
import com.valo.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        // 创建代理对象 使用Proxy
        // 1.创建目标对象
        UsbSell target = new UsbKingFactory();
        System.out.println("target:"+target.getClass().getName());
        // 2.创建InvocationHandler对象
        InvocationHandler handler = new MySellHandler(target);

        // 3.创建代理对象
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        // proxy:com.sun.proxy.$Proxy0 这是jdk动态代理创建的对象类型
        System.out.println("proxy:"+proxy.getClass().getName());

        // 4.通过代理执行方法
        float result = proxy.sell(20);
        System.out.println(result);
    }
}
