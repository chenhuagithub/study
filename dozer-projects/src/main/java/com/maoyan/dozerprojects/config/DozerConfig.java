package com.maoyan.dozerprojects.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenhua11
 * @date 2021/7/19  10:18 上午
 */
@Configuration
public class DozerConfig {
    @Bean
    public DozerBeanMapper getDozerBean() {
        DozerBeanMapper dozerBean = new DozerBeanMapper();
        return dozerBean;
    }
}