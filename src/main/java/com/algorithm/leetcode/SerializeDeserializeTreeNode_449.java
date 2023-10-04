package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author scott
 * @date 2023/9/4 23:14
 */
public class SerializeDeserializeTreeNode_449 {

//public class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;
// TreeNode(int x) { val = x; }




//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//            StringBuilder builder = new StringBuilder();
//            builder.append("[");
//            while(root != null) {
//                builder.append(root.val + ",");
//                if (root.left != null) {
//                    builder.append()
//                }
//            }
//            }
//
//        }
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//
//        }

    public int minimumPossibleSum(int n, int target) {
        long m = Math.min(target / 2, n);
        return (int)( (m * (m + 1) + (-m + target * 2 + n - 1) * (n - m)) / 2 % (1000000007));
    }

    @Test
    public void test1() {
//        Assert.assertEquals(4, minimumPossibleSum(2,3));
        Assert.assertEquals(156198582, minimumPossibleSum(39636,49035));


    }

    public static void main(String[] args) {
        System.out.println(Math.pow(10, 9)+ 7);
    }
}