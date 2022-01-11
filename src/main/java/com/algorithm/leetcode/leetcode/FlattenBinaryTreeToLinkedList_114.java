package com.algorithm.leetcode.leetcode;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author scott
 * @date 2020/8/2 21:26
 */
public class FlattenBinaryTreeToLinkedList_114 {

    public void flatten1(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                result.add(currNode);
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            currNode = currNode.right;
        }

        for (int i = 1; i < result.size(); i++) {
            TreeNode frontNode = result.get(i - 1);
            TreeNode curr = result.get(i);
            // 变成单链表 左子树都是null
            frontNode.left = null;
            frontNode.right = curr;
        }
    }

    public void flatten2(TreeNode root) {
        while (root != null) {
            // 节点的左子树不为null
            if (root.left != null) {
                TreeNode left = root.left;
                TreeNode temp = left;
                // 找到左子树的最后一个元素
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = root.right;
                root.left = null;
                root.right = left;
            }
            // 左子树为null 直接把右子树挂在当前节点上
            root = root.right;
        }
    }


    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(5, null, new TreeNode(6, null, null)));
        flatten1(node1);
    }
}

