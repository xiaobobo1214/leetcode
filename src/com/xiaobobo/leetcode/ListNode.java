/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname ListNode
 * @Description TODO
 * @Date 2020/12/9 3:55 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListNode(int[] vals) {
        int size = vals.length;
        ListNode res = new ListNode();
        ListNode[] nodes = new ListNode[vals.length];
        nodes[0] = new ListNode(vals[0]);
        for (int i = 1; i <= size; i++) {
            if (i == size) {
                nodes[i - 1].next = null;
                break;
            }
            nodes[i] = new ListNode(vals[i]);
            nodes[i - 1].next = nodes[i];
        }
        return nodes[0];
    }

    public static ListNode buildListNode() {
        int[] vals = new int[10];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = i;
        }
        return buildListNode(vals);
    }

    public static ListNode customListNode(Integer... nodeVals) {
        int[] vals = new int[nodeVals.length];
        for (int i = 0; i < nodeVals.length; i++) {
            vals[i] = nodeVals[i];
        }
        return buildListNode(vals);
    }

    @Override
    public String toString() {
        String and = "->";
        ListNode cur = this;
        String res = "";
        while (cur != null) {
            res += cur.val;
            if (cur.next != null) {
                res += and;
            }
            cur = cur.next;
        }
        return res;
    }
}