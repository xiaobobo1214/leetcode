/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname S167
 * @Description TODO
 * @Date 2020/12/15 6:16 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        while (left < right) {
            map.put(numbers[right], right + 1);
            map.put(numbers[left], left + 1);
            if (map.get(target - numbers[left]) != null) {
                res[0] = map.get(numbers[left]);
                res[1] = map.get(target - numbers[left]);
                return res;
            } else if (map.get(target - numbers[right]) != null) {
                res[0] = map.get(numbers[right]);
                res[1] = map.get(target - numbers[right]);
                return res;
            }
            right--;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,4};
        int target = 6;
        new S167().twoSum(numbers, target);
    }
}
