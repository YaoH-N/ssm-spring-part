package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * Author: 牛耀辉
 * Date: 2024/10/18 10:28
 * Description: 使用普通方式进行事务的添加
 */
@Component
public class TxAdvice {

    public void begin(JoinPoint joinPoint) {
        System.out.println("开启事务");
    }

    public void commit(Object result) {
        System.out.println("事务提交");
    }

    public void rollback(JoinPoint joinPoint, Throwable t) {
        System.out.println("事务回滚");
    }
}
