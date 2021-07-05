/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S108
 * @Description TODO
 * @Date 2020/12/14 2:55 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(nums[nums.length/2]);
        for(int i = 0; i < nums.length;i++){
            if(i == nums.length/2){
                continue;
            }

            buildTree(root, nums[i]);


        }
        return root;
    }

    public void buildTree(TreeNode root,int val){
        if(val > root.val){
            if(root.right == null){
                root.right = new TreeNode(val);
                return ;
            }else{
                buildTree(root.right, val);
            }
        }
        if(val <= root.val){
            if(root.left == null){
                root.left = new TreeNode(val);
                return ;
            }else{
                buildTree(root.left, val);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        new S108().sortedArrayToBST(nums);
    }
}
