/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.sort.impl;

import com.xiaobobo.sort.Sort;

/**
 * @Classname QuickSort
 * @Description TODO
 * @Date 2020/12/12 3:30 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }

    private int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
        return nums;
    }

    private int partition(int[] nums, int left, int right) {
        //设置基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }
}
