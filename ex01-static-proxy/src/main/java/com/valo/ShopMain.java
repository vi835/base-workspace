package com.valo;

import com.valo.business.TaoBao;

/**
 * Hello world!
 */
public class ShopMain {
    public static void main(String[] args) {
        // 创建代理的商家taobao对象
        TaoBao taoBao = new TaoBao();
        float price = taoBao.sell(1);
        System.out.println("通过淘宝的商家 购买u盘的价格:" + price);
    }
}
