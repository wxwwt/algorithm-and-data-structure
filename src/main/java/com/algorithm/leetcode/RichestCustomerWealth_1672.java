package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/4/14 23:20
 */
public class RichestCustomerWealth_1672 {

    /**
     * 计算二维数组每行的数值，求最大值
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }
            max = Math.max(max, temp);
        }
        return max;
    }

    @Test
    public void test1() {
        Assert.assertEquals(6, maximumWealth(new int[][]{{1,2,3},{3,2,1}}));
        Assert.assertEquals(10, maximumWealth(new int[][] {{1,5},{7,3},{3,5}}));
        Assert.assertEquals(17, maximumWealth(new int[][]{{2,8,7},{7,1,3},{1,9,5}}));
    }
}