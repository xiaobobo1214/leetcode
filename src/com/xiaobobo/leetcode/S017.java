/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname S017
 * @Date 2021/4/13 上午9:14
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class S017 {
    List<String> res = new ArrayList<>();
    private String[] button =
            {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        findCombinations(digits.toCharArray(), 0, "");
        return res;
    }

    // curRes中保存的是从[0...index-1]组合得到的字符串
    private void findCombinations(char[] digits, int index, String curRes) {

        if (index == digits.length) {
            // 保存s
            res.add(curRes);
            return;
        }

        char c = digits[index];
        String letters = button[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(digits, index + 1, curRes + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        new S017().letterCombinations("234");
    }

}
