/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode.listnode;

import com.xiaobobo.leetcode.ListNode;

/**
 * @Classname S092
 * @Description TODO
 * @Date 2021/3/30 下午3:56
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S092 {

    public static void main(String[] args) {
        new S092().reverseBetween(ListNode.customListNode(1,2,3,4,5), 2,4);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode tempNode = new ListNode(-999);
        tempNode.next = head;

        ListNode leftTail = tempNode;
        for(int i = 0; i < left - 1; i++){
            leftTail = leftTail.next;
        }
        ListNode midEnd = leftTail;
        for(int i = left; i < right + 1 ; i++){
            midEnd = midEnd.next;
        }

        ListNode mid = leftTail.next;
        ListNode rightNode = midEnd.next;

        leftTail.next = null;
        midEnd.next = null;

        leftTail.next = reverse(mid);
        mid.next = rightNode;
        return tempNode.next;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }
}
