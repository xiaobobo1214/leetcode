/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S004
 * @Description 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * @Date 2020/10/21 7:43 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0.0000;
        int index1 = 0, index2 = 0, index = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int[] arr = new int[len1 + len2];

        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] <= nums2[index2]) {
                arr[index] = nums1[index1];
                index1++;
                index++;
            } else {
                arr[index] = nums2[index2];
                index2++;
                index++;
            }
        }
        for (; index1 < len1; index1++,index++) {
            arr[index] = nums1[index1];
        }
        for (; index2 < len2; index2++,index++) {
            arr[index] = nums2[index2];
        }
        res = index%2==0?(double) (arr[index/2-1]+arr[index/2])/2 : arr[(index-1)/2];
        return res;
    }

    public static void main(String[] args) {
        S004 s = new S004();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        //s.findMedianSortedArrays(nums1,nums2);
        double res = (double) 5/2;
        System.out.println(res);
    }
}
