package com.algorithm.leetcode.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author scott
 * @date 2022/1/11 21:55
 */
public class FindLargestValueInEachTreeRow_515 {


    /**
     * 层序遍历 广度优先遍历
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (treeNodeQueue.size() > 0) {
            int curSize = treeNodeQueue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < curSize; i++) {
                TreeNode tempNode = treeNodeQueue.poll();
                max = Math.max(max, tempNode.val);

                if (tempNode.left != null) {
                    treeNodeQueue.offer(tempNode.left);
                }

                if (tempNode.right != null) {
                    treeNodeQueue.offer(tempNode.right);
                }
            }
            result.add(max);

        }
        return result;
    }


    List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues2(TreeNode root) {
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode treeNode, int level) {
        if (treeNode == null) {
            return;
        }

        if (level == result.size()) {
            result.add(treeNode.val);
        } else {
            result.set(level, Math.max(treeNode.val, result.get(level)));
        }


        dfs(treeNode.left, level + 1);
        dfs(treeNode.right, level + 1);
    }

    @Test
    public void test1() {
        List<Integer> list = largestValues(new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9))));
        Assert.assertEquals(Lists.newArrayList(1, 3, 9), list);

        List<Integer> list2 = largestValues2(new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9))));
        Assert.assertEquals(Lists.newArrayList(1, 3, 9), list2);
    }
}