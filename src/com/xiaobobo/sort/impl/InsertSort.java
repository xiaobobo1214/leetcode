/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.sort.impl;

import com.xiaobobo.sort.Sort;

/**
 * @Classname InsertSort
 * @Description 插入排序
 * @Date 2020/12/12 2:00 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class InsertSort implements Sort {

    /**
     *
     * @param nums
     */
    @Override
    public int[] sort(int[] nums) {
        // 选择下标为1的元素开始插入
        for (int i = 1; i < nums.length; i++) {
            // 记录未插入的数字
            int unSortNum = nums[i];
            for (int j = i-1; j >= 0; j--) {
                if(unSortNum < nums[j]){
                    nums[j+1] = nums[j];
                    nums[j] = unSortNum;
                }
            }
        }
        return nums;
    }
}
