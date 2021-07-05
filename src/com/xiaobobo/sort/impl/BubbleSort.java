/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.sort.impl;

import com.xiaobobo.sort.Sort;

/**
 * @Classname BubbleSort
 * @Description 冒泡排序
 * @Date 2020/12/12 1:28 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class BubbleSort implements Sort {

    /**
     * 从左到右不断交换相邻逆序的元素
     * 在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
     *
     * @param nums
     */
    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }
}
