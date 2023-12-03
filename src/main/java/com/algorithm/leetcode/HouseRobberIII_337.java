package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class HouseRobberIII_337 {


    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }


    public int[] dfs(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        // 选了根节点 = 不选左孩子 + 不选右孩子 + root.val
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int rob = left[1] + right[1] + node.val;
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, notRob};
    }

    @Test
    public void test() {
        Assert.assertEquals(7, rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
    }


    public class TreeNode {
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
