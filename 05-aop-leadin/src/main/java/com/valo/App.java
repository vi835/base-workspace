package com.valo;

import com.valo.Service.SomeService;
import com.valo.Service.impl.SomeServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 调用doSome doOther
        SomeService someService = new SomeServiceImpl();
        someService.doSome();
        System.out.println("==========================");
        someService.doOther();
    }
}
