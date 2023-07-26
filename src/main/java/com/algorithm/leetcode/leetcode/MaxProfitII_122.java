package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/25 22:50
 */
public class MaxProfitII_122 {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1 ; i < prices.length; i++) {
           int temp =  prices[i] - prices[i - 1];
            if (temp > 0) {
                max += temp;
            }
        }
        return max;
    }

    @Test
    public void test1() {
        Assert.assertEquals(7, maxProfit(new int[]{7,1,5,3,6,4}));

        Assert.assertEquals(4, maxProfit(new int[]{1,2,3,4,5}));
        Assert.assertEquals(0, maxProfit(new int[]{7,6,4,3,1}));
        Assert.assertEquals(15, maxProfit(new int[]{7,6,5,20}));
    }
}