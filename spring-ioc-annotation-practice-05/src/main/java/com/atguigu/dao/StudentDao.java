package com.atguigu.dao;

import com.atguigu.pojo.Student;

import java.util.List;

/**
 * Author: 牛耀辉
 * Date: 2024/9/20 22:59
 * Description: 学员持久层访问接口
 */
public interface StudentDao {

    List<Student> queryAll();
}
