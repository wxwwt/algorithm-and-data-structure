package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LCP_369_3 {

    public long minIncrementOperations1(int[] nums, int k) {

        int dp1 = 0, dp2 = 0, dp3 = 0;
        for (int num : nums) {
            // 如果把当前数字调整为不小于 k 的数需要的操作数量为 Math.max(0, k - num)
            // 而此前需要的操作数量为 Math.min(dp1, dp2, dp3)
            // 原来距离为 1 变为距离为 2
            // 原来距离为 2 变为距离为 3
            int tmp = Math.min(Math.min(dp1, dp2), dp3) + Math.max(0, k - num);
            dp1 = dp2;
            dp2 = dp3;
            dp3 = tmp;
        }
        return Math.min(Math.min(dp1, dp2), dp3);

    }


    public long minIncrementOperations2(int[] nums, int k) {

        long[] dp = new long[nums.length];
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i < 3) {
                dp[i] = Math.max(k - nums[i], 0);
            } else {
                dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 3]) + Math.max(0, k - nums[i]);
            }
        }
        return Math.min(Math.min(dp[n - 1], dp[n - 2]), dp[n - 3]);

    }


    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long[][] memo = new long[n][3];
        for (long[] m : memo) {
            // -1 表示没有计算过
            Arrays.fill(m, -1);
        }
        return dp(n - 1, 0, memo, nums, k);
    }

    private long dp(int i, int j, long[][] memo, int[] nums, int k) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // nums[i] 增大
        long res = dp(i - 1, 0, memo, nums, k) + Math.max(k - nums[i], 0);
        // nums[i] 不增大
        if (j < 2) {
            res = Math.min(res, dp(i - 1, j + 1, memo, nums, k));
        }
        return memo[i][j] = res;
    }


    @Test
    public void test() {
        Assert.assertEquals(3, minIncrementOperations(new int[]{2, 3, 0, 0, 2}, 4));
        Assert.assertEquals(2, minIncrementOperations(new int[]{0, 1, 3, 3}, 5));
    }
}
