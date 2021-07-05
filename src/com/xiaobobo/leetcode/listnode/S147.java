/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode.listnode;

import com.xiaobobo.leetcode.ListNode;

/**
 * @Classname S147
 * @Date 2021/5/25 下午4:50
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class S147 {
    public static void main(String[] args) {
        new S147().insertionSortList(ListNode.customListNode(-1, 5, 3, 4, 0));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 初始化新链表
        ListNode res = head;
        head = head.next;
        res.next = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            ListNode pre = null;
            ListNode cur = res;
            while (cur != null) {
                if (head.val < cur.val) {
                    if (pre == null) {
                        head.next = res;
                        res = head;
                    } else {
                        ListNode newNext = pre.next;
                        pre.next = head;
                        head.next = newNext;
                    }
                    break;
                } else if (cur.next == null) {
                    cur.next = head;
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
            head = next;
        }
        return res;
    }
}
