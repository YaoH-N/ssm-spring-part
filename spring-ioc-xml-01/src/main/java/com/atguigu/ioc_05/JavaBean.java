package com.atguigu.ioc_05;

/**
 * @author: 牛耀辉
 * @createTime: 2024/7/21 16:47
 * @description:
 */
public class JavaBean {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
