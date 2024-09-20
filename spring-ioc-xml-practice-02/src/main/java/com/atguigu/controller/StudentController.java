package com.atguigu.controller;

import com.atguigu.pojo.Student;
import com.atguigu.service.StudentService;

import java.util.List;

/**
 * @author: 牛耀辉
 * @createTime: 2024/7/23 16:37
 * @description:
 */
public class StudentController {

    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll() {
        List<Student> studentList = studentService.findAll();
        System.out.println("最终学生数据为: " + studentList);
    }
}
