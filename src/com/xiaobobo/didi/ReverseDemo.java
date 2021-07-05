/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.didi;

/**
 * @Classname ReverseDemo
 * @Date 2021/6/26 下午2:26
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class ReverseDemo {

    public static void main(String[] args) {
        String str = "poiu tr ew q";
        System.out.println(reverse(str));
    }

    public static String reverse(String str) {
        final char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}
