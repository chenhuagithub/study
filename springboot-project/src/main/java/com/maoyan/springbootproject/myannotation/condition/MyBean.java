package com.maoyan.springbootproject.myannotation.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenhua11
 * @date 2021/5/19  6:00 下午
 */

@Configuration
public class MyBean {
    @Bean
    @ConditionalOnExpression("${mybean.enable:true} and ${otherbean.enable:true}")
    public MyBeanComponent myBeanComponent() {
        return new MyBeanComponent();
    }
}
