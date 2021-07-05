/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.object;

import org.apache.lucene.util.RamUsageEstimator;

/**
 * @Classname ObjectTest
 * @Date 2021/5/11 上午9:50
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class ObjectTest {
    public static void main(String[] args) {
        Object[] arr = new Object[100];
        Object obj = new Object();
        String arrSize = RamUsageEstimator.humanSizeOf(arr);
        String objSize = RamUsageEstimator.humanSizeOf(obj);
        System.out.println("new Object[100] -> " + arrSize);
        System.out.println("new Object -> " + objSize);
    }
}
