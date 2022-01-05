package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/1/4 23:38
 */
public class SameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

//        if ((p == null && q != null) ||(p != null && q == null)) {
//            return false;
//        }

        // 改为使用异或更加简洁
        if (p == null ^ q == null) {
            return false;
        }

        if (p.val == q.val) {
            if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        TreeNode p = new TreeNode(1, new TreeNode(2, null, null), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2, null,null));
        Assert.assertFalse(isSameTree(p,q));
    }

    @Test
    public void test2() {
        TreeNode p = new TreeNode(0, new TreeNode(-5, null, null), null);
        TreeNode q = new TreeNode(0, new TreeNode(-8, null,null),null );
        Assert.assertFalse(isSameTree(p,q));
    }
}

