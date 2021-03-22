package com.valo.factory;

import com.valo.service.UsbSell;

// 目标类 金士顿厂家 不接受用户的单独购买
public class UsbKingFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        // 一个128G的u盘是85元
        // 后期根据amount 可以实现不同的价格 例如10000个单价是80 50000个单价是75
        return 85.0f;
    }
}
