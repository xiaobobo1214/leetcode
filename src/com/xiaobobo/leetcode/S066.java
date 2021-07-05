/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S066
 * @Description TODO
 * @Date 2020/11/16 8:54 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S066 {
    public int[] plusOne(int[] digits) {
        boolean flag = true;

        for (int i = digits.length-1; i >= 0 ; i--) {
            digits[i] += 1;
            if(digits[i]>=10){
                digits[i] -= 10;
                flag = false;
            }else {
                flag = true;
            }

            if(flag){
                return digits;
            }
        }

        int[] res = new int[digits.length+1];
        res[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            res[i+1] = digits[i];
        }

        return res;
    }

    public static void main(String[] args) {
        S066 s = new S066();
        int[] nums = {9};
        s.plusOne(nums);
    }
}
