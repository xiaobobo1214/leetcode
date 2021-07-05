/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S203
 * @Description TODO
 * @Date 2020/12/9 3:55 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S203 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        S203 s = new S203();
        s.removeElements(node1, 6);
    }
    public ListNode removeElements(ListNode head, int val) {

        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode cur = head;
        ListNode pre = tempHead;
        while(cur!=null){
            if(cur.val==val){
                pre = cur.next;
            }else{
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }
}

