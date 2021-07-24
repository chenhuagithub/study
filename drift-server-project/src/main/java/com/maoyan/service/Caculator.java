package com.maoyan.service;

import io.airlift.drift.annotations.ThriftMethod;
import io.airlift.drift.annotations.ThriftService;

/**
 * @author chenhua11
 * @date 2021/6/27  10:56 上午
 */

@ThriftService
public class Caculator {
    
    @ThriftMethod
    public int add(int x, int y){
        return x + y;
    }
    
    @ThriftMethod
    public int div(int x, int y) {
        return x - y;
    }
}