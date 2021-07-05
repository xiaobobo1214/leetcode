/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.didi;

import com.xiaobobo.sort.Sort;

/**
 * @Classname BBSort
 * @Date 2021/6/26 下午2:22
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class BBSort implements Sort {
    @Override
    public int[] sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,5,4};
        final int[] sort = new BBSort().sort(nums);
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }
}
