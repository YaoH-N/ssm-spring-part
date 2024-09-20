package com.atguigu.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author: 牛耀辉
 * Date: 2024/9/20 22:21
 * Description:
 */
@Component
public class JavaBean {
    /**
     * <bean id class
     *      <property name="name" value="二狗子"
     */

    // 方案1：直接赋值
    // 方案2：注解赋值 @Value注解 直接赋值  读取外部配置文件
    //       默认值语法 @Value(${key:value默认值})
    private String name = "二狗子";

    @Value("19")
    private int age;


    @Value("${jdbc.username:admin}") // 设置默认值admin
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
