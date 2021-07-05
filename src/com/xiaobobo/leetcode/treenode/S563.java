/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode.treenode;

import com.xiaobobo.leetcode.TreeNode;

/**
 * @Classname S563
 * @Date 2021/5/25 下午7:58
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class S563 {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        addVal(root);
        return Math.abs((root.left == null ? 0 : root.left.val) - (root.right == null ? 0 : root.right.val)) + findTilt(root.left) + findTilt(root.right);
    }

    public int addVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        root.val += addVal(root.left) + addVal(root.right);
        return root.val;
    }

    public static void main(String[] args) {
        new S563().findTilt(TreeNode.buildTree(21, new Integer[]{7, 14}, new Integer[]{7, 1, 2, 2}));
    }
}
