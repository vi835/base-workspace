package com.valo.business;

import com.valo.factory.UsbKingFactory;
import com.valo.service.UsbSell;

// taobao是一个商家 代理金士顿u盘的销售
public class TaoBao implements UsbSell {

    // 声明 商家代理的厂家具体是谁
    private UsbKingFactory factory = new UsbKingFactory();

    // 实现销售u盘功能
    @Override
    public float sell(int amount) {
        // 向厂家发送订单 告诉厂家 我买了U盘 厂家发货
        float price = factory.sell(amount);

        // 在目标类的方法调用后 你做的其他功能 都是增加的功能
        // 商家需要加价 也就是代理要增加价格
        price += 25;

        // 增加之后的价格
        return price;
    }
}
