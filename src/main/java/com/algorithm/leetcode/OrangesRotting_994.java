package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author scott
 * @date 2023/8/12 16:48
 */
public class OrangesRotting_994 {

    int r;
    int c;
    int[][] area;

    public int orangesRotting(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        area = grid;
        Queue<int[]> queue = new LinkedList<>();
        // 先找到所有的烂橘子
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            int value = grid[x][y] == 1 ? grid[x][y] = -1 : grid[x][y];
            result = Math.min(value, result);
            value = value == 2 ? 0 : value;
            if (inArea(x + 1, y)) {
                queue.offer(new int[]{x + 1, y});
                grid[x + 1][y] = value - 1;
            }

            if (inArea(x - 1, y)) {
                queue.offer(new int[]{x - 1, y});
                grid[x - 1][y] = value - 1;
            }

            if (inArea(x, y + 1)) {
                queue.offer(new int[]{x, y + 1});
                grid[x][y + 1] = value - 1;
            }

            if (inArea(x, y - 1)) {
                queue.offer(new int[]{x, y - 1});
                grid[x][y - 1] = value - 1;
            }
        }

        // 如果有橘子没腐烂直接返回-1
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result < 0 ? -result : result;
    }

    public boolean inArea(int x, int y) {
        if (0 <= x && x < r && 0 <= y && y < c && area[x][y] == 1) {
            return true;
        }
        return false;
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, orangesRotting(new int[][]{{2, 2}, {1, 1}, {0, 0}, {2, 0}}));
        Assert.assertEquals(-1, orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        Assert.assertEquals(4, orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        Assert.assertEquals(0, orangesRotting(new int[][]{{0, 2}}));
    }

}