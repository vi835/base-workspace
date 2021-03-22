package com.valo.business;

import com.valo.factory.UsbKingFactory;
import com.valo.service.UsbSell;

public class WeiShang implements UsbSell {
    // 代理的是金士顿 定义目标厂家类
    private UsbKingFactory factory = new UsbKingFactory();

    @Override
    public float sell(int amount) {
        // 调用目标方法
        float price = factory.sell(amount);

        price +=1;
        return price;
    }
}
