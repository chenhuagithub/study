package com.maoyan;

import com.google.common.base.Optional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenhua11
 * @date 2021/6/10  2:39 下午
 */
public class OptionalTest {
    
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.fromNullable(5);
        System.out.println(optional.orNull());
        Set<Integer> set = optional.asSet();
        System.out.println(set);
        
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        System.out.println(hashSet);
    }
}