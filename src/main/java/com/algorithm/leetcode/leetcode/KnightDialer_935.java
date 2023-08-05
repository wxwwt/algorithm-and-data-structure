package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/7/30 10:13
 */
public class KnightDialer_935 {

    public int knightDialer(int n) {
        int mod = 1000_000_007;
        // 定义dp数组dp[i][j] 是第i次，以j结尾的有效次数
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = (dp[i - 1][4] + dp[i - 1][6]) % mod;
            dp[i][1] = (dp[i - 1][6] + dp[i - 1][8]) % mod;
            dp[i][2] = (dp[i - 1][7] + dp[i - 1][9]) % mod;
            dp[i][3] = (dp[i - 1][4] + dp[i - 1][8]) % mod;
            dp[i][4] = (dp[i - 1][0] + dp[i - 1][3] + dp[i-1][9]) % mod;
            dp[i][6] = (dp[i - 1][0] + dp[i - 1][1] + dp[i-1][7]) % mod;
            dp[i][7] = (dp[i - 1][2] + dp[i - 1][6]) % mod;
            dp[i][8] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][9] = (dp[i - 1][2] + dp[i - 1][4]) % mod;
        }
        return (int)Arrays.stream(dp[n - 1]).asLongStream().sum() % mod ;
    }

    @Test
    public void test1() {
//        Assert.assertEquals(10 , knightDialer(1));
//        Assert.assertEquals(20,knightDialer(2));
        Assert.assertEquals(3131, knightDialer(136006598));
    }
}
