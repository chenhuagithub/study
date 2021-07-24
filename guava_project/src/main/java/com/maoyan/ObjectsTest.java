package com.maoyan;

import com.google.common.base.Objects;

/**
 * @author chenhua11
 * @date 2021/6/10  3:37 下午
 */
public class ObjectsTest {
    public static void main(String[] args) {
        System.out.println(Objects.equal(null, null));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.hashCode("a", "b", "c"));
    
    }
}