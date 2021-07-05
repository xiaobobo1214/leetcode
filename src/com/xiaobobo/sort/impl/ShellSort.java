/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.sort.impl;

import com.xiaobobo.sort.Sort;

/**
 * @Classname ShellSort
 * @Description TODO
 * @Date 2020/12/12 2:22 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class ShellSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        for (int step = nums.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                int temp = nums[i];
                int j = i - step;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + step] = nums[j];
                    j -= step;
                }
                nums[j + step] = temp;
            }
        }
        return nums;
    }
}
