/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.mianshi;

import java.util.*;

/**
 * @Classname Tiger
 * @Date 2021/6/18 下午6:24
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class Tiger {
    public static void main(String[] args) {
        System.out.println(isTrue("{}[](){{[{}]}}"));
    }

    private final static Map<Character, Character> map = new HashMap<>();
    private final static Set<Character> set;

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        set = new HashSet<>(map.values());
    }

    public static boolean isTrue(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (set.contains(c)) {

                if (!stack.isEmpty() && stack.get(stack.size() - 1) == '(' && c != '(') {
                    return false;
                } else if (!stack.isEmpty() && stack.get(stack.size() - 1) == '[' && c == '{') {
                    return false;
                }
                stack.push(c);
                continue;
            }
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}