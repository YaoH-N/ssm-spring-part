package com.atguigu.test;

import com.atguigu.config.JavaConfiguration;
import com.atguigu.config.JavaConfigurationA;
import com.atguigu.config.JavaConfigurationB;
import com.atguigu.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: 牛耀辉
 * Date: 2024/9/26 09:59
 * Description:
 */

public class SpringIoCTest {

    @Test
    public void test() {
        //1. 创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();
        applicationContext1.register(JavaConfiguration.class);
        applicationContext1.refresh(); //ioc di

        //2. 获取bean
        StudentController bean = applicationContext.getBean(StudentController.class);
        StudentController bean1 = applicationContext1.getBean(StudentController.class);

        System.out.println("bean = " + bean  );
        System.out.println("bean1 = " + bean1  );
    }

    @Test
    public void test_04(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfigurationA.class, JavaConfigurationB.class);
        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(JavaConfigurationA.class);

    }
}
