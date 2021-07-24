package com.maoyan.dozerprojects;

import com.maoyan.dozerprojects.bean.User;
import com.maoyan.dozerprojects.bean.UserDozer;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class DozerProjectsApplicationTests {
    
    @Autowired
    private DozerBeanMapper dozerBeanMapper;
    
    @Test
    void contextLoads() {
        User user = new User();
        user.setId(1);
        user.setAge("23.46");
        UserDozer userDozer = dozerBeanMapper.map(user, UserDozer.class);
        System.out.println(user);
        System.out.println(userDozer);
    }
    
    @Test
    public void test2() {
        BigDecimal bigDecimal = new BigDecimal("23.45");
        String string = bigDecimal.toString();
        BigDecimal ret = new BigDecimal(string);
        ret = ret.add(BigDecimal.valueOf(3));
        System.out.println(ret);
    }
    
}
