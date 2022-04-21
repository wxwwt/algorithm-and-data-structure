package com.algorithm.leetcode.completition;

import org.junit.Assert;
import org.junit.Test;

/**
 * 宝石补给
 * @author scott
 * @date 2022/4/16 15:02
 */
public class LCP_50 {


    public int giveGem(int[] gem, int[][] operations) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < operations.length; i++) {
            int from = operations[i][0];
            int to = operations[i][1];
            int num = gem[from] / 2;
            gem[from] -= num;
            gem[to] += num;
        }

        for (int item : gem) {
            max = Math.max(item, max);
            min = Math.min(item, min);
        }
        return max - min;

    }

    @Test
    public void test1() {
        Assert.assertEquals(5, giveGem(new int[]{5, 2}, new int[][]{{0, 0}, {1, 0}}));

        Assert.assertEquals(2, giveGem(new int[]{3, 1, 2}, new int[][]{{0, 2}, {2, 1}, {2, 0}}));
        Assert.assertEquals(75, giveGem(new int[]{100, 0, 50, 100}, new int[][]{{0, 2}, {0, 1}, {3, 0}, {3, 0}}));
        Assert.assertEquals(0, giveGem(new int[]{0, 0, 0, 0}, new int[][]{{1, 2}, {3, 1}, {1, 2}}));


    }

    public static void main(String[] args) {
        System.out.println(1/2);
        System.out.println(5/2);
    }
}