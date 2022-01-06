package com.algorithm.leetcode.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2022/1/5 23:18
 */
public class BinaryTreeRightSideView_199 {

    class TreeNodeWrapper {
        TreeNode treeNode;
        int depth;

        public TreeNodeWrapper(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    /**
     * 使用一个队列和一个数组完成了，队列用来深度遍历，
     * 数组用来储存每层里面的弹出的第一个参数，就是最右边的元素。
     * 还用了一个封装的树节点对象，每个元素多加了一个深度，用来遍历的时候
     * 标记每个元素在第几层
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        // 用来广度优先遍历用的队列
        Queue<TreeNodeWrapper> treeNodeQueue = new LinkedList<>();
        // 用来储存每层最先的节点的值 最上面的是第0层 对应数组的0下标的数据
        Integer[] depthArr = new Integer[101];
        if (root == null) {
            return new ArrayList<>();
        }
        int depth = 0;
        TreeNode curNode = root;
        depthArr[0] = root.val;
        treeNodeQueue.add(new TreeNodeWrapper(curNode, depth));

        while (treeNodeQueue.size() > 0) {
            TreeNodeWrapper tempNode = treeNodeQueue.poll();
            if (depthArr[tempNode.depth] == null) {
                depthArr[tempNode.depth] = tempNode.treeNode.val;
            }

            if (tempNode.treeNode.right != null) {
                treeNodeQueue.add(new TreeNodeWrapper(tempNode.treeNode.right, tempNode.depth + 1));
                depth = tempNode.depth + 1;
            }

            if (tempNode.treeNode.left != null) {
                treeNodeQueue.add(new TreeNodeWrapper(tempNode.treeNode.left, tempNode.depth + 1));
                depth = tempNode.depth + 1;
            }
        }

        depthArr = Arrays.copyOfRange(depthArr, 0, depth + 1);
        return Arrays.asList(depthArr);
    }

    @Test
    public void test1() {
        List<Integer> list = rightSideView(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4))));
        Assert.assertEquals(list, Lists.newArrayList(1, 3, 4));
    }
}