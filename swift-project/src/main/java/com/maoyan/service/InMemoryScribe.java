package com.maoyan.service;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import com.maoyan.bean.LogEntry;
import com.maoyan.utils.ResultCode;

import java.util.List;

@ThriftService("scribe")
public class InMemoryScribe
{
    private final List<LogEntry> messages = new ArrayList<>();

    public List<LogEntry> getMessages()
    {
        return messages;
    }

    @ThriftMethod("Log")
    public ResultCode log(List<LogEntry> messages)
    {
        this.messages.addAll(messages);
        return ResultCode.OK;
    }
}
