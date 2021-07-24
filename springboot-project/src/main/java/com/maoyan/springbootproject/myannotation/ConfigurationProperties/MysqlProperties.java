package com.maoyan.springbootproject.myannotation.ConfigurationProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chenhua11
 * @date 2021/5/19  4:29 下午
 */
@ConfigurationProperties(prefix = "db")
@Data
public class MysqlProperties {
    private String username;
    private String password;
    private String url;
    private String driverClassName;
}