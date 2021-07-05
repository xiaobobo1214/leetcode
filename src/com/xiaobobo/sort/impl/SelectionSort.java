/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.sort.impl;

import com.xiaobobo.sort.Sort;

/**
 * @Classname SelectionSort
 * @Description 选择排序
 * @Date 2020/12/12 1:44 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class SelectionSort implements Sort {

    /**
     * 从数组中选择最小的一个元素让他与第一个交换位置
     *
     * @param nums
     */
    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }


}
