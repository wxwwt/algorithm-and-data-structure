package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author scott
 * @date 2023/8/25 8:48
 */
public class MaxTaxiEarnings_2008 {

    public long maxTaxiEarnings(int n, int[][] rides) {
        List<long[]>[] groups = new ArrayList[n + 1];
        Arrays.setAll(groups, item -> new ArrayList<>());
        for (int[] ride : rides) {
           groups[ ride[1]].add(new long[]{ride[0], ride[1], ride[2]});
        }

        long ans = 0L;
        long[] dp = new long[n + 1];
        for(int end = 1; end <= n ; end++) {
            // 以i结尾的最大金额
            // 选择不接乘客i
            dp[end] = dp[end - 1];
            for (long[] group : groups[end]) {
                // 选择接上乘客i 就找到以end结尾的乘客中能接到的最大值
                dp[end] = Math.max(dp[end], dp[(int)group[0]] + group[1] - group[0] + group[2]);
            }
        }
        return dp[n];
    }

    @Test
    public void test1() {
        Assert.assertEquals(7, maxTaxiEarnings(5, new int[][]{{2,5,4}, {1,5,1}}));

        Assert.assertEquals(20, maxTaxiEarnings(20, new int[][]{{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}}));
    }
}