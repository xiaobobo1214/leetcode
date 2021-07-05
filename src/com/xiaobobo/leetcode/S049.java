/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.*;

/**
 * @Classname S049
 * @Description TODO
 * @Date 2020/12/14 2:05 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            if (strs[i] == "1") {
                continue;
            }
            if(strs[i]=="" || i == strs.length-1){
                list.add(strs[i]);
                res.add(list);
                strs[i] = "1";
                continue;
            }
            list.add(strs[i]);
            Set set = new HashSet();
            for (char c : strs[i].toCharArray()) {
                set.add(c);
            }
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j] == "1") {
                    continue;
                }
                boolean flag = true;
                if(strs[j].length()==set.size()){
                    for (char c : strs[j].toCharArray()) {
                        if (!set.contains(c)) {
                            flag = false;
                        }
                    }
                }
                if (flag) {
                    list.add(strs[j]);
                    strs[j] = "1";
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        //String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"","b"};
        new S049().groupAnagrams(strs);
    }
}
