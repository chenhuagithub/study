package com.maoyan.utils;


import io.airlift.drift.annotations.ThriftEnum;
import org.apache.thrift.TEnum;


@ThriftEnum
public enum ResultCode
        implements TEnum
{
    OK(0),
    TRY_LATER(1);

    private final int value;

    ResultCode(int value)
    {
        this.value = value;
    }

    /**
     * Get the integer value of this enum value, as defined in the Thrift IDL.
     */
    @Override
    public int getValue()
    {
        return value;
    }

    /**
     * Find a the enum type by its integer value, as defined in the Thrift IDL.
     *
     * @return null if the value is not found.
     */
    public static ResultCode findByValue(int value)
    {
        switch (value) {
            case 0:
                return OK;
            case 1:
                return TRY_LATER;
            default:
                return null;
        }
    }
}