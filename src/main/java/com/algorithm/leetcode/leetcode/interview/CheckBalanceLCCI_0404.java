package com.algorithm.leetcode.leetcode.interview;

import org.junit.Assert;
import org.junit.Test;

/**
 * 检查平衡性
 *
 * @author shenchuang
 * @since 2020-05-05
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }

}

public class CheckBalanceLCCI_0404 {

    public boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        // 递归左子树和右子树的深度 相差大于1就不平衡
        getDepth(root, 0);
        return isBalanced;
    }

    private int getDepth(TreeNode node, int currentDepth) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left, currentDepth);
        int rightDepth = getDepth(node.right, currentDepth);
        // 不平衡
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
            return -1;
        }
        // 左右两边的子树选最多深度的加一 就是当前节点的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        Assert.assertTrue(isBalanced(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node4.right = node6;
        Assert.assertFalse(isBalanced(root));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isBalanced(null));
    }
}
