package com.atguigu.controller;

import com.atguigu.pojo.Student;
import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Author: 牛耀辉
 * Date: 2024/9/20 23:09
 * Description:
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void findAll(){
        List<Student> studentList = studentService.findAll();
        System.out.println("all = " + studentList);
    }
}
