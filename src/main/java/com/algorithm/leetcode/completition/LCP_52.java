package com.algorithm.leetcode.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 二叉搜索树染色
 * @author scott
 * @date 2022/4/16 15:41
 */
public class LCP_52 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 一开始想法是把节点存到数组里面，然后根据染色的变化去修改数组中的值，写完反正超时了。
     * 比赛结束后，看了别人的题解才明白要么反向染色，要么可以用线段树。线段树看了半天没看懂，最后
     * 还是用简单的反向染色完成了。
     * 反向染色：因为只需要管被染成红色的，然后是后面的操作会覆盖前面的，所以只需要从ops反向遍历，
     * 比如说一个点，进行了好几次染色操作，但是只要这个节点在ops操作的范围之内，然后最后的操作是
     * 红色，就要记录一个染色的点。
     * 如果是蓝色，那就不用管直接跳过，依次遍历掉每个点即可找到有多少个红色的点。
     * 时间复杂度：O(ni), n是节点的数量，i是操作的次数
     * 空间复杂度：O(1), 没有额外开辟空间
     * @param root
     * @param ops
     * @return
     */


    int [][] ops;
    int result;
    public int getNumber(TreeNode root, int[][] ops) {
        result = 0;
       this.ops = ops;
       dfs(root);
       return result;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.left);
            dfs(node.right);
            check(node.val);
        }
    }

    private void check(int value) {
        for(int i = ops.length - 1; i >= 0; i--) {
            // 检查如果在操作范围之内，红色加一（正好ops[i][0]如果是红色就是1）然后退出，蓝色直接退出
            if (value >= ops[i][1] && value <= ops[i][2] ) {
                result += ops[i][0];
                break;
            }
        }
    }

    @Test
    public void test1() {
        Assert.assertEquals(2,
                getNumber(new TreeNode(1, null,
                                new TreeNode(2, null,
                                        new TreeNode(3, null,
                                                new TreeNode(4, null,
                                                        new TreeNode(5, null, null))))),
                        new int[][]{{1, 2, 4}, {1, 1, 3}, {0, 3, 5}}));

        Assert.assertEquals(5,
                getNumber(new TreeNode(4,
                                new TreeNode(2, new TreeNode(1, null, null), null),
                                new TreeNode(7, new TreeNode(5, null, new TreeNode(6, null, null)), null)),
                        new int[][]{{0, 2, 2}, {1, 1, 5}, {0, 4, 5}, {1, 5, 7}}));

    }
}

