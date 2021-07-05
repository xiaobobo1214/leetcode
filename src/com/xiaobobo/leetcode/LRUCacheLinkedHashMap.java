/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname LRUCacheLinkedHashMap
 * @Description TODO
 * @Date 2021/3/30 上午11:33
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class LRUCacheLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int val) {
        super.put(key, val);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > capacity;
    }
}
