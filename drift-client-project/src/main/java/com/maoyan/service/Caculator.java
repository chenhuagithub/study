package com.maoyan.service;

import io.airlift.drift.annotations.ThriftMethod;
import io.airlift.drift.annotations.ThriftService;

/**
 * @author chenhua11
 * @date 2021/6/27  10:56 上午
 */

@ThriftService
public interface Caculator {
    
    @ThriftMethod
    int add(int x, int y);
    
    @ThriftMethod
    int div(int x, int y);
}