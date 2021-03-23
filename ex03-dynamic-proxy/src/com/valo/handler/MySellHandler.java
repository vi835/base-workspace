package com.valo.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 必须实现InvocationHandler中的接口 完成代理类要做的功能(1.调用目标方法 2.功能增强)
public class MySellHandler implements InvocationHandler {
    private Object target = null;

    // 动态代理 目标对象是活动的 不是固定的 需要传入进来
    // 传入是谁 就给谁创建代理
    public MySellHandler(Object target) {
        // 给目标对象赋值
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        result = method.invoke(target, args);
        if (result != null)
            result = (float) result + 25;

        return result;
    }
}
