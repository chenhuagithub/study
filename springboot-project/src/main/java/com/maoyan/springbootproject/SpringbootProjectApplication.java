package com.maoyan.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootProjectApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringbootProjectApplication.class, args);
    }
    
}
