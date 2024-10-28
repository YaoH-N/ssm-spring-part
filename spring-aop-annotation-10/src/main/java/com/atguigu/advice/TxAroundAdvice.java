package com.atguigu.advice;

import com.alibaba.druid.sql.ast.statement.SQLJoinTableSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Author: 牛耀辉
 * Date: 2024/10/18 10:33
 * Description: 环绕通知
 */
@Aspect
@Component
public class TxAroundAdvice {

    /**
     * 环绕通知，需要在通知中，定义目标方法的执行!
     * @param joinPoint  目标方法(获取目标方法信息，多了一个执行方法)
     * @return 目标方法的返回值
     */
    @Around("com.atguigu.pointcut.MyPointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint){

        // 保证目标方法被执行即可
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            // 增强代码 -> before
            System.out.println("开启事务");
            result = joinPoint.proceed(args);
            System.out.println("结束事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            // 必须再抛出异常
            throw new RuntimeException(e);
        }

        return result;
    }

}
