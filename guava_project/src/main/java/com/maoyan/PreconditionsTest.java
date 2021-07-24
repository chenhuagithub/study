package com.maoyan;

import com.google.common.base.Preconditions;

/**
 * @author chenhua11
 * @date 2021/6/10  3:19 下午
 */
public class PreconditionsTest {
    public static void main(String[] args) {
        int i = 4;
        Preconditions.checkArgument(i >= 0, "%s 必须大于0", i);
        Preconditions.checkPositionIndexes(1,4, 5);
    }
}