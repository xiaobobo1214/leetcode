/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S006
 * @Description TODO
 * @Date 2020/10/29 10:38 上午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S006 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     *
     * 输出：LCIRETOESIIGEDHN
     */
    public String convert(String s, int numRows) {
        if(s.length() < numRows || numRows == 1) return s;
        StringBuffer res = new StringBuffer();
        char[] chars = s.toCharArray();
        char[][] resArr = new char[numRows][(chars.length+numRows)/2];
        int m = 0, n=0;
        boolean down = true;
        for (char c : chars) {
            resArr[m][n] = c;
            if(m==numRows-1) down = false;
            if(m==0) down = true;
            if(down){
                m++;
            }else {
                m--;
                n++;
            }
        }

        for (int i = 0; i < resArr.length; i++) {
            for (int j = 0; j < resArr[0].length; j++) {
                if(resArr[i][j] != 0){
                    res.append(resArr[i][j]);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        S006 s = new S006();
        System.out.println(s.convert("AB", 1));
    }
}
