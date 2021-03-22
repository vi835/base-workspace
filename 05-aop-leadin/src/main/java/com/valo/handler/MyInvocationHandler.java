package com.valo.handler;

import com.valo.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    // 目标对象
    private Object target;// SomeServiceImpl类

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行了MyInvocationHandler中的invoke方法");

        System.out.println("method名称:" + method.getName());
        String methodName = method.getName();

        // 通过代理对象执行方法时 会调用执行这个invoke()
        Object result = null;

        if ("doSome".equals(methodName)) {
            // 在目标方法之前 输出时间
            ServiceTools.doLog();

            // 执行目标类的方法 通过Method类实现
            result = method.invoke(target, args);// SomeServiceImpl里的方法

            // 在目标方法执行之后 提交事务
            ServiceTools.doTrans();
        } else {
            result = method.invoke(target, args);
        }


        // 目标方法的执行结果
        return result;
    }
}
