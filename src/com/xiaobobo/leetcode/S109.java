/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S109
 * @Description TODO
 * @Date 2020/11/18 10:26 上午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        while (head != null) {
            setTreeRight(root, head.val);
            head = head.next;
        }
        return leftRotate(root);
    }


    public static void main(String[] args) {
        final S109 s = new S109();
        ListNode node1 = new ListNode(0);
//        ListNode node2 = new ListNode(-3);
//        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(9);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        s.sortedListToBST(node1);


    }

    public void setTreeRight(TreeNode root, int val) {
        if (root.right != null) {
            setTreeRight(root.right, val);
        } else {
            root.right = new TreeNode(val);
        }
    }

    public TreeNode leftRotate(TreeNode root) {
        TreeNode newRoot = root.right;
        if(newRoot==null){
            return root;
        }
        root.right = newRoot.left;
        newRoot.left = root;
        if (high(newRoot.right) - high(newRoot.left) > 1) {
            return leftRotate(newRoot);
        }
        return newRoot;
    }

    public int high(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHigh = high(root.left);
        int rHigh = high(root.right);
        if (lHigh > rHigh) {
            return lHigh + 1;
        } else {
            return rHigh + 1;
        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
