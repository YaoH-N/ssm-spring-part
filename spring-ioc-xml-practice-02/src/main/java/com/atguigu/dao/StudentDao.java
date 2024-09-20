package com.atguigu.dao;

import com.atguigu.pojo.Student;

import java.util.List;

/**
 * @author: 牛耀辉
 * @createTime: 2024/7/23 16:17
 * @description: 数据层接口
 */
public interface StudentDao {

    /**
     * 数据库查询全部学生数据
     * @return
     */
    List<Student> queryAll();
}
