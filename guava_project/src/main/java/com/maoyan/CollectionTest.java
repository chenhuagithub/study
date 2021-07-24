package com.maoyan;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * @author chenhua11
 * @date 2021/6/10  4:30 下午
 */
public class CollectionTest {
    public static void main(String[] args) {
        ImmutableSet<String> set = ImmutableSet.of("red",
                "orange",
                "yellow",
                "green",
                "blue",
                "purple");
        System.out.println(set);
        ImmutableSortedSet<String> sortSet = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
        System.out.println(sortSet);
        ImmutableMap<String, Integer> map = ImmutableMap.of("1", 1, "2", 2);
        System.out.println(map);
        Multiset<String> multiset = ImmutableMultiset.of("111", "111", "333","222");
        
        System.out.println(multiset.count("111"));
        System.out.println(multiset.count("222"));
        System.out.println("---------------------------");
        ArrayList<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        Map<String, String> hashMap = Maps.newHashMap();
        hashMap.put("1", "1");
        HashMultiset<Object> objects = HashMultiset.create();
        System.out.println("------------------------------");
        Joiner joiner = Joiner.on(";").useForNull("NULL");
        String res = joiner.join("Harry", null, "Ron", "Hermione");
        System.out.println(res);
        System.out.println("--------------");
        String str = ",a,,b,";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println("-------------");
        Iterable<String> split1 = Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .split(str);
        Iterator<String> iterator = split1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------------");
    }
}