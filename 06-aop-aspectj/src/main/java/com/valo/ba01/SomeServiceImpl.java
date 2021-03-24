package com.valo.ba01;

import org.springframework.stereotype.Component;

@Component
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 给doSome方法增加一个功能 在执行doSome()执行之前 输出方法的执行时间
        System.out.println("=====目标方法doSome()=====");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("=====目标方法Other()=====");
        return "abcd";
    }
}
