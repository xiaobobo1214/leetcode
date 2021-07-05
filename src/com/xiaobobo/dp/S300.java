/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.dp;

import java.util.Arrays;

/**
 * @Classname S300
 * @Date 2021/4/16 下午7:08
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class S300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = dp[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        new S300().lengthOfLIS(nums);
    }
}
