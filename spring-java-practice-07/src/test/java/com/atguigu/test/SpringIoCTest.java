package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: 牛耀辉
 * Date: 2024/9/28 09:50
 * Description:
 */
public class SpringIoCTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.findAll();
    }
}
