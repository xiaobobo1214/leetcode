/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode.treenode;

import com.xiaobobo.leetcode.TreeNode;

import java.util.*;

/**
 * @Classname TreeNodeDemo
 * @Date 2021/3/2 下午7:03
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class TreeNodeDemo {

    public static Integer NULL_VALUE = 0;

    public static void main(String[] args) {

        int top1 = 1;
        Integer[] middle1 = {3, 2};
        Integer[] bottom1 = {5, NULL_VALUE, NULL_VALUE, NULL_VALUE};
        TreeNode root1 = TreeNode.buildTree(top1, middle1, bottom1);

        int top2 = 2;
        Integer[] middle2 = {1, 3};
        Integer[] bottom2 = {NULL_VALUE, 4, NULL_VALUE, 7};
        TreeNode root2 = TreeNode.buildTree(top2, middle2, bottom2);

        //mergeTrees(root1, root2);
        //minDepth(TreeNode.buildTree(2, new Integer[]{NULL_VALUE, 3}, new Integer[]{NULL_VALUE, 4, NULL_VALUE, 5}));
        //pathSum(TreeNode.buildTree(5, new Integer[]{4,8}, new Integer[]{11,NULL_VALUE, 13, 4}),20);
//        sumNumbers(TreeNode.buildTree(1, new Integer[]{2, 3}, new Integer[]{NULL_VALUE, NULL_VALUE, NULL_VALUE, NULL_VALUE}));

        // kthSmallest(TreeNode.buildTree(3, new Integer[]{1, 4}, new Integer[]{null, 2, null, null}), 1);
        //constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        //sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
//        TreeNode.buildTree(1, new Integer[]{2, 3}, new Integer[]{4, 5, 6, 7}).levelOrder();
        //levelOrder(TreeNode.buildTree(1, new Integer[]{2, 3}, new Integer[]{4, 5, 6, 7}));
        levelTreeNode(TreeNode.buildTree(1, new Integer[]{2, 3}, new Integer[]{4, 5, 6, 7}), 3);
    }




    public static List<Integer> levelTreeNode(TreeNode root, int level) {
        List<Integer> res = new ArrayList<>();
        levelTreeNodeHelper(root, level, res);
        return res;
    }

    public static void levelTreeNodeHelper(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            res.add(root.val);
            return;
        }
        levelTreeNodeHelper(root.left, level - 1, res);
        levelTreeNodeHelper(root.right, level - 1, res);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public static TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, start, mid - 1);
        root.right = build(nums, mid + 1, end);
        return root;
    }

    public static int[] levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return constructMaximumBinaryTree(nums, start, end);
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return root;

    }


    public static int res = 0;

    public static int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return res;
    }

    public static void kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthSmallestHelper(root.left, k);
        k--;
        if (k == 0) {
            res = root.val;
        } else {
            kthSmallestHelper(root.right, k);
        }
        return;
    }

    /**
     * S129
     *
     * @param root
     * @return
     */
    public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private static int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        //叶子结点
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }

        return helper(root.left, 10 * sum + root.val) +
                helper(root.right, 10 * sum + root.val);

    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        dfs_pathSum(root, sum, new ArrayList<>(), res);
        return res;
    }

    private static void dfs_pathSum(TreeNode root, int sum, List<Integer> arr, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        List<Integer> tmp = new ArrayList<>(arr);
        tmp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(tmp);
            return;
        }

        dfs_pathSum(root.left, sum - root.val, tmp, res);
        dfs_pathSum(root.right, sum - root.val, tmp, res);
    }


    /**
     * 最小深度 层次遍历
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node.left == null && node.right == null) {
                return res;
            }

            queue.offer(node.left);
            queue.offer(node.right);

            res++;
        }
        return res;
    }

    /**
     * 合并二叉树
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    /**
     * 翻转二叉树
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

}
