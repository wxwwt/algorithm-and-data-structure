package com.algorithm.leetcode;

/**
 * @author scott
 * @date 2019/11/10 17:06
 */
public class UniquePaths2_63 {

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

    /**
     * 新增提交方法
     * 定义dp[i][j] 是终点是坐标为i,j机器人能到达的方式
     * 如果当前位置是障碍物，dp[i][j]就是0，因为无法到达那个位置
     * 如果当前位置是没有障碍物，dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
     * 初始化：dp[1][1]  就是原地不动的话，就是1
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
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


    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

}