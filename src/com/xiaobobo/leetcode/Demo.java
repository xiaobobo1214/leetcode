/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2021/3/29 下午4:30
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class Demo {

    public String minWindow(String s, String t) {




        String res = null;
        int min = s.length();
        int[] tFreq = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }
        // 窗口边界
        int start = 0;
        int end = -1;

        while (start < s.length()) {
            if (end + 1 < s.length() && end - start + 1 < min) {
                end++;
            } else {
                start++;
                end = start;
            }
            if (end + 1 - start >= t.length() && min >= end + 1 - start && checkStr(s.substring(start, end + 1 < s.length()?end+1:s.length()), tFreq, t)) {
                min = end + 1 - start;
                res = s.substring(start, end + 1);
            }
        }
        return res;
    }

    private boolean checkStr(String str, int[] tFreq, String s) {
        int[] strFreq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            strFreq[str.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (strFreq[s.charAt(i)] != tFreq[s.charAt(i)]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaab";
        String t = "ab";
        //new Demo().minWindow(s, t);
    }
}
