package com.maoyan.bean;

import io.airlift.drift.annotations.ThriftConstructor;
import io.airlift.drift.annotations.ThriftField;
import io.airlift.drift.annotations.ThriftStruct;

@ThriftStruct
public class Bonk
{
    private final String message;
    private final int type;
    
    @ThriftConstructor
    public Bonk(String message, int type)
    {
        this.message = message;
        this.type = type;
    }
    
    @ThriftField(1)
    public String getMessage()
    {
        return message;
    }
    
    @ThriftField(2)
    public int getType()
    {
        return type;
    }
}

