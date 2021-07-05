/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.dp;

/**
 * @Classname S005
 * @Date 2021/4/16 上午9:29
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class S005 {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        //这里i要从最后一个开始遍历
        for (int i = length - 1; i >= 0; i--) {
            //单个字符也是一个回文串
            dp[i][i] = 1;
            //j从i的下一个开始
            for (int j = i + 1; j < length; j++) {
                //下面是递推公式
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        print(dp);
        return dp[0][length - 1];
    }

    private void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        String s = "CBABC";
        new S005().longestPalindromeSubseq(s);
    }
}
