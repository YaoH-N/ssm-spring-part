package com.atguigu.ioc_03;

import org.springframework.stereotype.Service;

/**
 * @author: 牛耀辉
 * @createTime: 2024/9/1 14:02
 * @description:
 */
@Service
public class NewUserServiceImpl implements UserService {

    @Override
    public String show() {
        return "newUserServiceImpl show()";
    }
}
