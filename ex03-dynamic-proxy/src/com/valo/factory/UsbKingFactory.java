package com.valo.factory;

import com.valo.service.UsbSell;

// 目标类
public class UsbKingFactory implements UsbSell {
    // 目标方法
    @Override
    public float sell(int amount) {
        System.out.println("目标类中 执行sell目标方法");
        return 85.0f;
    }
}
