package com.atguigu.ioc_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Author: 牛耀辉
 * Date: 2024/9/26 09:47
 * Description:
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
}
