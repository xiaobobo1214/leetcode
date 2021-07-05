/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode.listnode;

import com.xiaobobo.leetcode.ListNode;

/**
 * @Classname S061
 * @Description TODO
 * @Date 2021/3/30 上午10:12
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S061 {



    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = new ListNode(-999);
        temp.next = head;
        ListNode slow = temp;
        ListNode fast = temp;
        ListNode cur = head;
        int m = 0;
        while (cur != null) {
            m++;
            cur = cur.next;
        }
        int n = 0;
        k %= m;
        while(fast.next != null){
            if (n < k) {
                fast = fast.next;
                n++;
                continue;
            }
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = temp.next;
        temp.next = slow.next;
        slow.next = null;
        return temp.next;
    }


    public ListNode partition(ListNode head, int x) {
        ListNode temp = new ListNode(-999);
        temp.next = head;
        ListNode fast = temp;
        ListNode slow = temp;
        while (fast.next !=null && fast.next.val<x){
            slow = slow.next;
            fast = fast.next;
        }

        while(fast.next != null){
            if(fast.next.val < x){
                ListNode t = fast.next;
                fast.next = fast.next.next;
                t.next = slow.next;
                slow.next = t;
                slow = slow.next;
            }else{
                fast = fast.next;
            }
        }

        return temp.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.customListNode(1, 4, 3, 2, 5, 2);
        new S061().partition(listNode, 3);
    }
}
