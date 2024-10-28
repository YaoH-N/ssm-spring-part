package com.atguigu.statics;

import com.atguigu.Calculator;

/**
 * Author: 牛耀辉
 * Date: 2024/10/4 16:46
 * Description: 代理类 [中介]
 */
public class StaticProxyCalculator implements Calculator {

    private Calculator calculator;

    public StaticProxyCalculator(Calculator target){
        this.calculator = target;
    }
    @Override
    public int add(int i, int j) {

        // 非核心业务 中介使用
        System.out.println("i = " + i + ", j = " + j);
        // 调用目标
        int result = calculator.add(1, 1);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
