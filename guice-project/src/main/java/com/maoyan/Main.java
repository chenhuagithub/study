package com.maoyan;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.maoyan.bean.Greeter;

/**
 * @author chenhua11
 * @date 2021/6/26  11:32 下午
 */
public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Greeter greeter = injector.getInstance(Greeter.class);
        greeter.setMessage("I am chenhua");
        greeter.setCount(4);
        greeter.sayHello();
    }
}