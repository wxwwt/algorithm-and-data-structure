package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/27 8:46
 */
public class NumIslands_200 {

    public int numIslands(char[][] grid) {
        int land = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    land++;
                    dfs(i, j, grid);
                }
            }
        }
        return land;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (0 <= i && i <= grid.length - 1 && 0 <= j && j <= grid[i].length - 1) {
//            System.out.println("遍历到grid[" + i + "][" + j + "]" + "值是" + grid[i][j]);
            if (grid[i][j] == '1') {
                // 标记为2 说明是陆地且被标记过
                grid[i][j] = '2';
                dfs(i, j + 1, grid);
                dfs(i, j - 1, grid);
                dfs(i + 1, j, grid);
                dfs(i - 1, j, grid);
            }
        }
    }


    @Test
    public void test1() {
        Assert.assertEquals(3, numIslands(new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}

        }));
    }

}