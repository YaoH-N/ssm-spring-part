package com.atguigu.ioc;

import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: 牛耀辉
 * Date: 2024/9/20 23:24
 * Description:
 */
public class SpringIoCTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.findAll();

    }
}
