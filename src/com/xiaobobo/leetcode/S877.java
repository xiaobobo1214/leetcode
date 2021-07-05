/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S877
 * @Date 2021/5/8 下午6:03
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class S877 {

    public boolean stoneGame(int[] piles) {
        int sumA = 0;
        int sumB = 0;

        int l = 0;
        int r = piles.length - 1;
        while(l < r){
            if(piles[l] > piles[r]){
                sumA += piles[l];
                l++;
            }else{
                sumA += piles[r];
                r--;
            }
            if(piles[l] > piles[r]){
                sumB += piles[l];
                l++;
            }else{
                sumB += piles[r];
                r--;
            }
        }
        return sumA >= sumB;
    }

    public static void main(String[] args) {
        int[] piles = {3,2,10,4};
        new S877().stoneGame(piles);
    }
}
