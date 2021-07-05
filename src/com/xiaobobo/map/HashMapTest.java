/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @Classname HashMapTest
 * @Date 2021/2/26 下午3:09
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class HashMapTest {
    public static void main(String[] args) {
//        Map<A, Integer> map = new HashMap<>();
//        for (int i = 0; i < 100; i++) {
//            map.put(new A(), i);
//        }
//        System.out.println(map);
        testTreeMap();
    }

    public static void testTreeMap(){
        Map<Long, Double> hashMap = new HashMap<>();
        hashMap.put(1L, 0.1);
        hashMap.put(2L, 0.2);
        hashMap.put(3L, 0.3);
        hashMap.put(4L, 0.4);

        Map<Long, Double> treeMap1 = new TreeMap<>();
        treeMap1.putAll(hashMap);

        Map<Long, Double> treeMap2 = new TreeMap<>();
        treeMap2.putAll(hashMap);
        System.out.println(Objects.equals(treeMap1, treeMap2));
    }

    public static void resize(Map<Integer, Integer> map) {
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
    }

    public static void get(Map<Integer, Integer> map) {
        for (int i = 0; i < 10; i++) {
            map.get(i);
        }
    }
}

class A {
    @Override
    public int hashCode() {
        return 1;
    }
}
