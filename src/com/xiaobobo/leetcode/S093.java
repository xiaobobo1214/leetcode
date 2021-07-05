/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname S093
 * @Date 2021/4/14 上午9:49
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class S093 {

    public static void main(String[] args) {
        String s = "25525511135";

        System.out.println(new S093().restoreIpAddresses(s));
    }

    public static final String dot = ".";
    public List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrace(s, 0, 0, "");
        return res;
    }

    public void backtrace(String s, int segCount, int index, String curRes) {
        // 四段ip  index到了最后一位 满足答案
        if (segCount == 4 || index == s.length()) {
            if (segCount == 4 && index == s.length()) res.add(curRes.substring(0, curRes.length()-1));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i >= s.length()) return;
            if (s.charAt(index) == '0' && i != 1) return;
            if (i == 3 && Integer.valueOf(s.substring(index, i + index)) > 255) return;
            curRes += s.substring(index, i + index);
            curRes += dot;
            backtrace(s, segCount + 1, index + i, curRes);
            curRes = curRes.substring(0, curRes.length() - i);
        }
    }
}
