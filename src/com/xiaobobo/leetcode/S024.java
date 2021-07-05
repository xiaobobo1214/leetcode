/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S024
 * @Description TODO
 * @Date 2020/11/17 3:26 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S024 {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     */

    public ListNode swapPairs(ListNode head) {
        ListNode swapped = null;


        while (head != null && head.next != null && head.next.next != null) {

        }
        return head;
    }

    public static void main(String[] args) {
        S024 s = new S024();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        s.swapPairs(node1);
    }


}
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
