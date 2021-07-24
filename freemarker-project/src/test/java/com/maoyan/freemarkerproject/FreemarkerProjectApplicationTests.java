package com.maoyan.freemarkerproject;

import com.maoyan.freemarkerproject.bean.User;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class FreemarkerProjectApplicationTests {
    
    @Autowired
    private Configuration cfg;
    
    
    @Test
    public void test4() {
        List<User> users = Arrays.asList(new User("111", "111"), new User("111", "222"), new User("222", "222"));
        Set<String> collect = users.stream().map(User::getUsername).collect(Collectors.toSet());
        System.out.println(collect);
        List<Integer> collect1 = collect.stream().map(String::hashCode).collect(Collectors.toList());
        System.out.println(collect1);
    }
    
    @Test
    void contextLoads() throws IOException, TemplateException {
        
        Template temp = cfg.getTemplate("test.html");
        StringWriter writer = new StringWriter();
        Map<String, User> root = new HashMap<>();
        User user = new User();
        user.setUsername("chenhua11");
        root.put("user", user);
        temp.process(root,writer);
        System.out.println(writer.toString());
    }
    
    
    @Test
    void test1() throws IOException, TemplateException {
        String content = "客户：${username}";
        StringTemplateLoader templateLoader = new StringTemplateLoader();
        templateLoader.putTemplate("emailTemplate", content);
        cfg.setTemplateLoader(templateLoader);
        Template temp = cfg.getTemplate("emailTemplate", "uft-8");
        System.out.println(temp);
        User user = new User();
        user.setUsername("张三");
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        temp.process(user, out);
    }

    
}
