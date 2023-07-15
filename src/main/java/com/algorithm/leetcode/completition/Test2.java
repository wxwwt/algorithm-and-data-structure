package com.algorithm.leetcode.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author scott
 * @date 2023/7/11 21:47
 */
public class Test2 {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i -1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (dp[i][j] == 0) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }

            }
        }
        return dp[m][n];
    }




    @Test
    public void test1() {
        Assert.assertEquals(2, uniquePathsWithObstacles(new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
        Assert.assertEquals(1, uniquePathsWithObstacles(new int[][]{
                {0, 1},
                {0, 0}
        }));
    }

}