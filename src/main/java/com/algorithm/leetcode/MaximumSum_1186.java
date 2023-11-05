package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/7/29 22:35
 */
public class MaximumSum_1186 {

    public int maximumSum(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        int[][] dp = new int[n][2];
        // dp[i][0] 是以i结尾，没有删除的情况下的最大和
        // dp[i][1]是以i结尾，有删除情况下的最大和
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        for (int i = 1 ; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i],  arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        return ans;
    }

    @Test
    public void test() {
//        Assert.assertEquals(17, maximumSum(new int[]{8,-1,6,-7,-4,5,-4,7,-6}));
//        Assert.assertEquals(4, maximumSum(new int[]{1,-2,0,3}));
//        Assert.assertEquals(3, maximumSum(new int[]{1,-2,-2,3}));
        Assert.assertEquals(-1, maximumSum(new int[]{-1,-1,-1,-1}));
    }
}