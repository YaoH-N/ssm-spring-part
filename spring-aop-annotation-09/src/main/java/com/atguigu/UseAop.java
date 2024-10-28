package com.atguigu;

import com.atguigu.statics.StaticProxyCalculator;

/**
 * Author: 牛耀辉
 * Date: 2024/10/4 16:49
 * Description:
 */
public class UseAop {
    public static void main(String[] args) {
        // 房东
        Calculator target = new CalculatorPureImpl();

        // 中介 代理
        Calculator proxy = new StaticProxyCalculator(target);

        // 调用
        int add = proxy.add(1, 1);
        System.out.println("add = " + add);
    }
}
