/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname TreeNode
 * @Date 2020/12/14 2:55 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(int top, Integer[] middle, Integer[] bottom) {
        TreeNode[] bottomNodes = new TreeNode[4];
        TreeNode[] middleNodes = new TreeNode[2];

        for (int i = 0; i < bottom.length; i++) {
            if (bottom[i] != null) {
                bottomNodes[i] = new TreeNode(bottom[i]);
            }
        }

        for (int i = 0; i < middle.length; i++) {
            if (middle[i] != null) {
                middleNodes[i] = new TreeNode(middle[i]);
            }
        }

        middleNodes[0].left = bottomNodes[0];
        middleNodes[0].right = bottomNodes[1];
        middleNodes[1].left = bottomNodes[2];
        middleNodes[1].right = bottomNodes[3];

        TreeNode root = new TreeNode(top);
        root.left = middleNodes[0];
        root.right = middleNodes[1];

        return root;
    }

    public void preOrder() {
        System.out.print(this.val + " ");
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void midOrder() {
        if (this == null) return;
        if (this.left != null) this.left.midOrder();
        System.out.print(this.val + " ");
        if (this.right != null) this.right.midOrder();
    }

    public void postOrder() {
        if (this == null) return;
        if (this.left != null) this.left.postOrder();
        if (this.right != null) this.right.postOrder();
        System.out.print(this.val + " ");
    }

    public void levelOrder() {
        LinkedList<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if(treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
    }
}
