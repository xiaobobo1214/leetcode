/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.Arrays;

/**
 * @Classname S581
 * @Date 2021/5/7 上午11:22
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class S581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedArr = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(sortedArr);
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedArr[i]) {
                l = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= l; i--) {
            if (nums[i] != sortedArr[i]) {
                r = i;
                break;
            }
        }
        return r - l + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new S581().findUnsortedSubarray(nums);
    }
}
