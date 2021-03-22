package com.valo.service.impl;

import com.valo.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("您好：" + name);
    }
}
