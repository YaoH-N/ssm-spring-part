package com.atguigu.service;

import com.atguigu.pojo.Student;

import java.util.List;

/**
 * @author: 牛耀辉
 * @createTime: 2024/7/23 16:34
 * @description: 学生业务接口
 */
public interface StudentService {

    List<Student> findAll();
}
