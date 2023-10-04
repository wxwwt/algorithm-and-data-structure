package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/27 8:46
 */
public class NumIslands_200 {

    public int numIslands1(char[][] grid) {
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

    class UnionFind {

        public int root[];

        // 用来统计最后有多少个岛屿
        int num;

        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            root = new int[row * col];
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (grid[r][c] == '1') {
                        // 如果是岛屿的话 num就增加
                        num++;
                        // 将二维坐标准换为一维的
                        root[r * col + c] = r * col + c;
                    }
                }
            }
        }


        // 优化点在这里 再查找父节点的同时会把根节点赋值给递归过程的其他元素
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                root[rootY] = rootX;
                num--;
            }
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int sea = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1') {
                    // 处理完之后 赋值为另外一个值 这样下次就不会重复遍历到这个值
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * col + c, (r - 1) * col + c);
                    }
                    if (r + 1 < row && grid[r + 1][c] == '1') {
                        uf.union(r * col + c, (r + 1) * col + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * col + c, r * col + c - 1);
                    }
                    if (c + 1 < col && grid[r][c + 1] == '1') {
                        uf.union(r * col + c, r * col + c + 1);
                    }
                }
            }
        }
        return uf.num;
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, numIslands(new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}

        }));

        Assert.assertEquals(1, numIslands(new char[][]{
                new char[]{'1', '1', '1'},
                new char[]{'0', '1', '0'},
                new char[]{'1', '1', '1'},


        }));
    }

}