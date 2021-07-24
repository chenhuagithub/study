package com.maoyan.springbootproject.controller;

import com.maoyan.bean.User;
import com.maoyan.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhua11
 * @date 2021/5/11  8:24 下午
 */
@RestController
public class TestController {
    
    @GetMapping("/test/get")
    public Result<List<User>> testGet () {
        User user1 = new User();
        BigDecimal num = new BigDecimal("3.30").setScale(2, BigDecimal.ROUND_HALF_UP);
        user1.setNum1(num.doubleValue());
        user1.setNum2(num);
        User user2 = new User();
        List<User> res = new ArrayList<>();
        res.add(user1);
        res.add(user2);
        return new Result<>(200, "post请求获取数据成功", res);
    }
    
    @PostMapping("/test/post")
    public Result<List<User>> testPost (String username, String password) {
        User user1 = new User();
        List<User> res = new ArrayList<>();
        res.add(user1);
        return new Result<>(200, "get请求获取数据成功", res);
    }
}