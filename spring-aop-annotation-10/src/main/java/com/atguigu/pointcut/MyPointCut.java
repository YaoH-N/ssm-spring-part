package com.atguigu.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author: 牛耀辉
 * Date: 2024/10/18 10:21
 * Description: 存储切点的类
 */
@Component
public class MyPointCut {

    @Pointcut("execution(* com.atguigu.service.impl.*.*(..))")
    public void pc(){}

    @Pointcut("execution(* com..impl.*.*(..))")
    public void myPc(){

    }
}
