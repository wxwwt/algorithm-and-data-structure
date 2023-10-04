package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author scott
 * @date 2023/8/12 10:03
 */
public class MaxDistance_1162 {

    int r = 0;
    int c = 0;
    int[][] area = null;

    /**
     * 使用多源bfs
     * 从陆地出发，向外扩散，最后被扩散到的海洋，就是距离陆地最远的海洋
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        r = grid.length;
        c = grid[0].length;
        area = grid;
        // 先把所有陆地都找到 然后加入到队列
        for (int i = 0; i < r; i++ ) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        if (queue.isEmpty() || queue.size() == r * c) {
            return -1;
        }


        int result = 0;
        while(!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            int value = grid[x][y] == 1 ? 0 : grid[x][y];
            result = Math.min(result, value);
            if (inArea(x + 1, y)) {
                queue.offer(new int[]{x + 1, y});
                grid[x+1][y] = value - 1;
            }

            if (inArea(x -1, y)) {
                queue.offer(new int[]{x - 1, y});
                grid[x-1][y] = value - 1;
            }

            if (inArea(x , y + 1)) {
                queue.offer(new int[]{x , y + 1});
                grid[x][y+1] = value - 1;
            }

            if (inArea(x , y - 1)) {
                queue.offer(new int[]{x, y - 1});
                grid[x][y-1] = value - 1;
            }
        }
        return -result;
    }


    public boolean inArea(int x, int y) {
        if (0 <= x & x < r && 0 <= y & y < c && area[x][y] == 0) {
            return true;
        }
        return false;
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
        Assert.assertEquals(4, maxDistance(new int[][]{{1,0,0},{0,0,0},{0,0,0}}));
        Assert.assertEquals(-1, maxDistance(new int[][]{{1}}));
        Assert.assertEquals(-1, maxDistance(new int[][]{{0}}));
        Assert.assertEquals(-1, maxDistance(new int[][]{{0}}));
        Assert.assertEquals(1, maxDistance(new int[][]{{0,1}}));
    }

}