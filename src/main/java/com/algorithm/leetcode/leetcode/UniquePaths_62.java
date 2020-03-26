package com.algorithm.leetcode.leetcode;

import java.util.Arrays;

/**
 * @author scott
 * @date 2019/11/3 20:26
 */
public class UniquePaths_62 {

    public static int uniquePaths(int m, int n) {
        if (m > 100 || n > 100) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static int uniquePaths2(int m, int n) {
        if (m > 100 || n > 100) {
            return 0;
        }

       int[] dp = new int[m > n ? m : n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                   dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n -1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(3, 7));
    }
}