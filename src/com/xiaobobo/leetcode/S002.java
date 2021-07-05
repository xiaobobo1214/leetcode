/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S002
 * @Description TODO
 * @Date 2020/10/13 5:02 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        int[] valArr = new int[1024];
        int index = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0, val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            valArr[index] = val1 + val2;
            index++;
        }
        for (int i = 0; i <= index; i++) {
            if (valArr[i] >= 10) {
                valArr[i] -= 10;
                valArr[i + 1] += 1;
            }
        }

        if (valArr[index] > 0){
            index++;
        }
        for (int i = index - 1; i >= 0; i--) {
            res = new ListNode(valArr[i],res);
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        //ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode l2 = new ListNode(5);
        S002 s = new S002();
        s.addTwoNumbers(l1, l2);
    }


}


