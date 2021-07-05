/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname S38
 * @Date 2021/5/27 上午10:33
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class S38 {

    public String[] permutation(String s) {

        Set<String> resSet = new HashSet<>();
        boolean[] visit = new boolean[s.length()];

        dfs(s, resSet, visit, "");

        String[] res = new String[resSet.size()];
        int i = 0;
        for (String value : resSet) {
            res[i++] = value;
        }
        return res;
    }

    private void dfs(String s, Set<String> resSet, boolean[] visit, String curRes) {
        if (curRes.length() == s.length()) {
            resSet.add(curRes);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(s, resSet, visit, curRes + s.charAt(i));
            visit[i] = false;
        }
    }


    public static void main(String[] args) {
        System.out.println(new S38().permutation("abc"));
    }


}
