/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */

package com.xiaobobo.sort;

/**
 * @Classname Sort
 * @Description TODO
 * @Date 2020/12/12 2:21 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public interface Sort {
    int[] sort(int[] nums);

    default void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
