package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * Author: 牛耀辉
 * Date: 2024/10/17 20:17
 * Description: 定义四个增强方法，获取目标方法的信息 返回值 异常对象
 * <p>
 * 1. 定义方法 - 增强代码
 * 2. 使用注解指定对应的位置
 * 3. 配置切点表达式选中的方法
 * 4. 切面和ioc的配置
 * 5. 开启aspectj注解的支持
 * <p>
 * TODO: 增强方法中获取目标方法信息
 *      1. 全部增强方法中，获取目标方法的信息(方法名，参数访问修饰符，所属的类的信息...)
 *          (JoinPoint joinPoint) import org.aspectj.lang.JoinPoint;
 *      2. 获取返回的结果 - @AfterReturning
 *          (Object result) result接收返回结果
 *          @AfterReturning(value = "execution(* com..impl.*.*(..))",returning = "形参名即可")
 *      3. 获取异常的信息 - @AfterThrowing
 *          (Throwable t) t接收异常信息
 *          @AfterThrowing(value = "execution(* com..impl.*.*(..))",throwing = "形参名即可")
 *
 */
@Aspect
@Component
public class MyAdvice {


    @Before("execution(* com..impl.*.*(..))")
    public void before(JoinPoint joinPoint) {

        //1. 获取方法属于的类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("simpleName = " + simpleName);
        //2. 获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers(); // 获取访问修饰符（int类型）
        String s = Modifier.toString(modifiers); // 将访问修饰符int类型转换为String类型
        String name = joinPoint.getSignature().getName();
        System.out.println("name = " + name);
        //3. 获取参数列表
        Object[] args = joinPoint.getArgs(); // 获取目标方法的参数
        System.out.println("args = " + args);


    }

    @AfterReturning(value = "execution(* com..impl.*.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("result = " + result);

    }

    @After("execution(* com..impl.*.*(..))")
    public void after(JoinPoint joinPoint) {

    }

    @AfterThrowing(value = "execution(* com..impl.*.*(..))",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint,Throwable throwable) {


    }

}
