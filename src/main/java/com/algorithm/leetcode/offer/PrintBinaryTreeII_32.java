package com.algorithm.leetcode.offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author scott
 * @date 2023/7/1 22:21
 */
public class PrintBinaryTreeII_32 {

    List<List<Integer>> result = new ArrayList<>() ;


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        result.add(first);
        while (!queue.isEmpty()) {
            recursion(queue, 0);

        }


        return result;
    }

    public void recursion(Queue<TreeNode> queue, int index) {
        if (queue.isEmpty()) {
            return;
        }

        if (result.get(index) == null) {
            result.add(new ArrayList<>());
        }

        TreeNode curNode = queue.poll();
        if (curNode.left != null) {
            queue.offer(curNode.left);
            result.get(index).add(curNode.left.val);
            recursion(queue, index + 1);
        }

        if (curNode.right != null) {
            queue.offer(curNode.left);
            result.get(index).add(curNode.right.val);
            recursion(queue, index + 1);
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        List<List<Integer>> list = new ArrayList<>();

        list.add(List.of(3));
        list.add(List.of(9, 20));
        list.add(List.of(15, 7));

        Assert.assertEquals(list, levelOrder(root));
    }

}