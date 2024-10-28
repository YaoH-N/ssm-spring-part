package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Author: 牛耀辉
 * Date: 2024/10/13 20:31
 * Description:
 */
@Configuration
@ComponentScan("com.atguigu")
@EnableAspectJAutoProxy // 开启aspectj的注解 == <aop:aspectj-autoproxy />
public class JavaConfig {
}
