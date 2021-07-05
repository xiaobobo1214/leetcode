/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S008
 * @Description TODO
 * @Date 2020/10/29 11:39 上午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S008 {
    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     * <p>
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     * <p>
     * 提示：
     * <p>
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     */
    public int myAtoi(String s) {
        if(s.length() == 0)return 0;
        s = s.replaceAll(" ", "");
        long res = 0;
        int i = 0;
        boolean flag = s.charAt(0)=='-';
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            s = s.substring(1);
        }
        for (; i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'; i++) {}
        String resValue = s.substring(0, i);
        if(flag) resValue = "-" + resValue;
        if(resValue.length() == 0)return 0;
        res = Long.parseLong(resValue);
        if(res>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if(res<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return (int) res;
    }

    public static void main(String[] args) {
        S008 s = new S008();
        String param = "-91283472332";
        System.out.println(s.myAtoi(param));
    }
}
