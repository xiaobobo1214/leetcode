/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.sort.impl;

import com.xiaobobo.sort.Sort;

import java.util.Arrays;

/**
 * @Classname MergeSort
 * @Description 归并排序
 * @Date 2020/12/12 2:34 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int[] left = Arrays.copyOfRange(nums, 0, nums.length / 2);
        int[] right = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int lIndex = 0, rIndex = 0;
        int index = 0;
        while (lIndex < left.length && rIndex < right.length) {
            if (left[lIndex] < right[rIndex]) {
                arr[index] = left[lIndex];
                lIndex++;
            } else {
                arr[index] = right[rIndex];
                rIndex++;
            }
            index++;
        }
        for (; lIndex < left.length; lIndex++) {
            arr[index] = left[lIndex];
            index++;
        }
        for (; rIndex < right.length; rIndex++) {
            arr[index] = right[rIndex];
            index++;
        }
        return arr;
    }

}
