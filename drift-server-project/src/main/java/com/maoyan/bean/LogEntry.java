package com.maoyan.bean;

import io.airlift.drift.annotations.ThriftConstructor;
import io.airlift.drift.annotations.ThriftField;
import io.airlift.drift.annotations.ThriftStruct;

/**
 * @author chenhua11
 * @date 2021/6/26  6:53 下午
 */
@ThriftStruct
public class LogEntry
{
    private final String category;
    private final String message;
    
    @ThriftConstructor
    public LogEntry(String category, String message)
    {
        this.category = category;
        this.message = message;
    }
    
    @ThriftField(1)
    public String getCategory()
    {
        return category;
    }
    
    @ThriftField(2)
    public String getMessage()
    {
        return message;
    }
}
