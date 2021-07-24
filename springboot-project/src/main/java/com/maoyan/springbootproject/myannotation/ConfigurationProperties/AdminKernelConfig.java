package com.maoyan.springbootproject.myannotation.ConfigurationProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenhua11
 * @date 2021/5/19  4:33 下午
 */
@Configuration
@EnableConfigurationProperties(MysqlProperties.class) // 用于指明配置类
public class AdminKernelConfig {
    
    @Bean
    public DynamicWechatRoute dynamicWechatRoute(MysqlProperties mysqlProperties) {
        return new DynamicWechatRoute(mysqlProperties);
    }
}