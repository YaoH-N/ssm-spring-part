package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.service.Calculator;
import com.atguigu.service.impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Author: 牛耀辉
 * Date: 2024/10/13 20:32
 * Description:
 */
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {

    // aop - 代理 -jdk - 接口 - 代理类 - 代理对象和目标对象 兄弟关系 - 接口接值
    // aop - ioc - 代理对象

    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        int add = calculator.add(1, 1);
        System.out.println("add = " + add);
    }
}
