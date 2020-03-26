package com.algorithm.leetcode.leetcode;

import java.util.Arrays;

/**
 * @author scott
 * @date 2019/11/10 17:06
 */
public class UniquePaths2_62 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length > 100 || obstacleGrid[0].length > 100) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
                } else if (i == 0) {
                    if (dp[i][j - 1] != 0 && obstacleGrid[i][j] != 1) {
                        dp[i][j] = 1;
                    }
                } else if (j == 0) {

                    if (dp[i - 1][j] != 0 && obstacleGrid[i][j] != 1) {
                        dp[i][j] = 1;
                    }
                } else if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

}