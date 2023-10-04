package com.algorithm.leetcode.offer;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

/**
 * @author scott
 * @date 2023/6/14 22:50
 */
public class Offer_32 {

    List<Integer> result = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return result.stream().mapToInt(item -> item).toArray();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            result.add(curNode.val);
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }

            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
        long st = System.currentTimeMillis();
        int [] temp = new int[0];
//        result.stream().mapToInt(item -> item).toArray();
        long et = System.currentTimeMillis();
        System.out.println(et-st);
        return temp;
    }

    public int[] levelOrder2(TreeNode root) {
        if( root == null ){
            return new int[0];
        }
        int[] result = new int[countTreeNode(root)];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 0;
        while( !queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size; i++){
                TreeNode node = queue.poll();
                int n = node.val;

                result[index++] = n;

                if( node.left != null){
                    queue.offer(node.left);
                }
                if( node.right != null){
                    queue.offer(node.right);
                }
            }

        }
        return result;

    }
    // 通过递归调用 countNodes 方法，就可以逐级计算二叉树中所有节点的总数。
    private int countTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + countTreeNode(root.left) + countTreeNode(root.right);
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;

        long st = System.currentTimeMillis();
        levelOrder(root);
        long et = System.currentTimeMillis();
        levelOrder2(root);
        long et2 = System.currentTimeMillis();
        System.out.println(et-st);
        System.out.println(et2-et);
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
}