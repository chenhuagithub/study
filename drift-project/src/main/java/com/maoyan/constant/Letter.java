package com.maoyan.constant;

import io.airlift.drift.annotations.ThriftEnum;
import io.airlift.drift.annotations.ThriftEnumValue;

@ThriftEnum
public enum Letter
{
    A(65), B(66), C(67), D(68);

    private final int asciiValue;

    Letter(int asciiValue)
    {
        this.asciiValue = asciiValue;
    }

    @ThriftEnumValue
    public int getAsciiValue()
    {
        return asciiValue;
    }
}
