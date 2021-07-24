package com.maoyan.freemarkerproject.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author chenhua11
 * @date 2021/7/1  10:58 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    private String username;
    private String password;
    
    
    public static void main(String[] args) {
        BigDecimal res = BigDecimal.valueOf(3).divide(BigDecimal.valueOf(10), 2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100));
        System.out.println(res);
        
    }
}