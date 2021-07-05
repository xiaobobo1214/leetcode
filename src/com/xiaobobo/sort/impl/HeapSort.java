/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.sort.impl;

import com.xiaobobo.sort.Sort;

/**
 * @Classname HeapSort
 * @Description TODO
 * @Date 2020/12/12 3:53 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        buildMaxHeap(nums, nums.length);
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            len--;
            heapify(nums, 0, len);
        }
        return nums;
    }

    private void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            heapify(nums, i, len);
        }
    }

    private void heapify(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIndex = i;
        if (left < len && nums[left] > nums[minIndex]) {
            minIndex = left;
        }
        if (right < len && nums[right] > nums[minIndex]) {
            minIndex = right;
        }
        if (minIndex != i) {
            swap(nums, i, minIndex);
            heapify(nums, minIndex, len);
        }
    }
}
