package com.atguigu.ioc_05;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author: 牛耀辉
 * @createTime: 2024/7/21 16:48
 * @description: 制造JavaBean的工厂bean对象
 *
 * 步骤：
 *      1. 实现FactoryBean接口 <返回值类型>
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    public void setValue(String value) {
        this.value = value;
    }

    private String value;


    @Override
    public JavaBean getObject() throws Exception {
        //使用自己的方式实例化对象
        JavaBean javaBean = new JavaBean();
        javaBean.setName(value);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
