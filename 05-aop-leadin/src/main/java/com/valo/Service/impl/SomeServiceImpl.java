package com.valo.Service.impl;

import com.valo.Service.SomeService;
import com.valo.util.ServiceTools;

import java.util.Date;

// service类的代码不修改 也能够增加输出时间 事务
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        // System.out.println("方法的执行时间:"+new Date());
        //  ServiceTools.doLog();
        System.out.println("执行业务方法doSome");

        // 方法的最后 提交事务
        // ServiceTools.doTrans();
        // System.out.println("方法执行完毕后 提交事务");
    }

    @Override
    public void doOther() {
       // System.out.println("方法的执行时间:" + new Date());
        System.out.println("执行业务方法doOther");

        // 方法的最后 提交事务
       // System.out.println("方法执行完毕后 提交事务");
    }
}
