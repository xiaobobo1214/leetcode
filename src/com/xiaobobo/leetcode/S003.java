/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname S003
 * @Description TODO
 * @Date 2020/10/20 8:05 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S003 {
    public int lengthOfLongestSubstring(String s) {
        int res = -1;
        int len = s.length();
        if (len < 2) return len;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (!set.add(s.charAt(j)) || j == len - 1) {
                    res = Math.max(res, set.size());
                    set.clear();
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = 0;
        }
        int l = 0;
        int r = -1;
        int res = 0;

        while (l < s.length()) {
            if (r < s.length() - 1 && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        S003 s = new S003();
        //s.lengthOfLongestSubstring("pwwkew");
        s.lengthOfLongestSubstring2("abcabcbb");

    }
}
