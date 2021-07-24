package com.maoyan.service;

import com.maoyan.bean.LogEntry;
import io.airlift.drift.annotations.ThriftMethod;
import io.airlift.drift.annotations.ThriftService;

import java.util.List;

@ThriftService
public class Scribe
{
    @ThriftMethod
    public int log(List<LogEntry> messages)
    {
        messages.forEach(message -> System.out.println(message.getMessage()));
        return 0;
    }
}
