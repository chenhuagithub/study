package com.maoyan.springbootproject.myannotation.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenhua11
 * @date 2021/5/19  4:36 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DynamicWechatRoute {
    private MysqlProperties testProperties;
}