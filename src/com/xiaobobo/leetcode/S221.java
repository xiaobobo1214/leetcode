/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S221
 * @Description TODO
 * @Date 2020/12/10 4:52 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S221 {
    public int maximalSquare(char[][] matrix) {
        //dp数组 && 第一行第一列初始化
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0;i<dp.length;i++) dp[i][0] = 0;
        for(int j = 0;j<dp[0].length;j++) dp[0][j] = 0;
        //返回值
        int res = 0;
        //初始化剩余数据
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                int n = char2Int(matrix[i][j]);
                dp[i+1][j+1] = n;
                res = Math.max(res,n);
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                if(dp[i][j] !=0 && dp[i-1][j-1] != 0 && dp[i-1][j] != 0 && dp[i][j-1] != 0){
                    int n = dp[i-1][j-1]+1;
                    dp[i][j] = n;
                    res = Math.max(n*n,res);
                }
            }
        }
        return res;
    }



    public int char2Int(char c){
        return (int)c - 48;
    }

    public static void main(String[] args) {
        //char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix = {{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}};
        new S221().maximalSquare(matrix);
    }
}
