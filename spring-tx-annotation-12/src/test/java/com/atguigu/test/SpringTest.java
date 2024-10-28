package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Author: 牛耀辉
 * Date: 2024/10/20 23:36
 * Description:
 */
@SpringJUnitConfig(JavaConfig.class)
public class SpringTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void test(){
        studentService.changeInfo();
    }
}
