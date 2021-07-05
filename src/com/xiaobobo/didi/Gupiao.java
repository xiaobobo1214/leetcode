/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.didi;

/**
 * @Classname Gupiao
 * @Date 2021/7/1 下午8:20
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class Gupiao {
    public static void main(String[] args) {
        int[] prices = {6,4,1,6,8,15,2,13,5};
        System.out.println(max(prices));
    }

    private static int max(int[] prices) {
        int res = -1;
        int last = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            last = Math.max(0, last + prices[i + 1] - prices[i]);
            res = Math.max(last, res);
        }
        return res;
    }
}
