package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/15 21:55
 */
public class IntegerBreak_343 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        // 外层记录的是dp[i]
        for (int i = 3; i <= n; i++) {
             // 内层计算的是dp[i]的情况下最大的乘积是多少
            int max = 0;
            for (int j = 1; j <= i / 2; j ++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return  dp[n];
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, integerBreak(2));
        Assert.assertEquals(18, integerBreak(8));
        Assert.assertEquals(36, integerBreak(10));
    }
}