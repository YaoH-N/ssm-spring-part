package com.atguigu.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: 牛耀辉
 * @createTime: 2024/9/1 13:49
 * @description:
 */
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON) //单例 默认值
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //多例
@Component
public class JavaBean {
    // 周期方法命名随意 public void 没有形参
    @PostConstruct
    public void init(){
        System.out.println("JavaBean.init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JavaBean.destroy");
    }


}
