/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S007
 * @Description TODO
 * @Date 2020/10/29 11:31 上午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S007 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     */
    public int reverse(int x) {
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int) res == res ? (int)res : 0;
    }
}
