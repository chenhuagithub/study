package com.maoyan.service;

import com.maoyan.bean.LogEntry;
import io.airlift.drift.annotations.ThriftMethod;
import io.airlift.drift.annotations.ThriftService;

import java.util.List;

@ThriftService
public interface Scribe
{
    @ThriftMethod
    int log(List<LogEntry> messages);
}
