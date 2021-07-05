/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S941
 * @Description TODO
 * @Date 2020/11/3 3:05 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S941 {
    /**
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
     *
     * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     *
     * A.length >= 3
     * 在 0 < i < A.length - 1 条件下，存在 i 使得：
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        if(A.length<3) return false;
        int maxIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if(A[i]>A[maxIndex]){
                maxIndex = i;
            }
        }
        for (int i = 0; i < maxIndex-1; i++) {
            if(A[i]>A[i+1]){
                return false;
            }
        }
        for (int i = maxIndex; i < A.length-1; i++) {
            if(A[i]<A[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        S941 s = new S941();
        int[] arr = {0,2,3,4,5,2,1,0};
        System.out.println(s.validMountainArray(arr));
    }
}
