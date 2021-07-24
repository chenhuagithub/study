package com.maoyan.springbootproject;


import com.maoyan.springbootproject.myannotation.ConfigurationProperties.DynamicWechatRoute;
import com.maoyan.springbootproject.myannotation.condition.MyBeanComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootProjectApplicationTests {
    
    @Autowired
    private DynamicWechatRoute dynamicWechatRoute;
    
    
    @Autowired
    private MyBeanComponent myBeanComponent;
    
    @Test
    public void myBean() {
        System.out.println(myBeanComponent);
    }
    
    
    @Test
    void contextLoads() {
        System.out.println(dynamicWechatRoute);
    }
    
}
