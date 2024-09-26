package com.atguigu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author: 牛耀辉
 * Date: 2024/9/26 23:27
 * Description: 配置类
 */
@Configuration
@Import(value = {JavaConfigurationB.class})
public class JavaConfigurationA {
}
