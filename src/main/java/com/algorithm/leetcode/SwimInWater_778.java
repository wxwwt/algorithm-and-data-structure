package com.algorithm.leetcode;

import com.algorithm.leetcode.template.UnionFind2;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/8/14 8:31
 */
public class SwimInWater_778 {

//    private int N;
//
//    public static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//
//    public int swimInWater(int[][] grid) {
//        this.N = grid.length;
//
//        int len = N * N;
//        // 下标：方格的高度，值：对应在方格中的坐标
//        int[] index = new int[len];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                index[grid[i][j]] = getIndex(i, j);
//            }
//        }
//
//        UnionFind unionFind = new UnionFind(len);
//        for (int i = 0; i < len; i++) {
//            int x = index[i] / N;
//            int y = index[i] % N;
//
//            for (int[] direction : DIRECTIONS) {
//                int newX = x + direction[0];
//                int newY = y + direction[1];
//                if (inArea(newX, newY) && grid[newX][newY] <= i) {
//                    unionFind.union(index[i], getIndex(newX, newY));
//                }
//
//                if (unionFind.isConnected(0, len - 1)) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    private int getIndex(int x, int y) {
//        return x * N + y;
//    }
//
//    private boolean inArea(int x, int y) {
//        return x >= 0 && x < N && y >= 0 && y < N;
//    }
//
//    private class UnionFind {
//
//        private int[] parent;
//
//        public UnionFind(int n) {
//            this.parent = new int[n];
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;
//            }
//        }
//
//        public int root(int x) {
//            while (x != parent[x]) {
//                parent[x] = parent[parent[x]];
//                x = parent[x];
//            }
//            return x;
//        }
//
//        public boolean isConnected(int x, int y) {
//            return root(x) == root(y);
//        }
//
//        public void union(int p, int q) {
//            if (isConnected(p, q)) {
//                return;
//            }
//            parent[root(p)] = root(q);
//        }
//    }
//

    int r ;

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
         r = grid.length;
        int c = grid[0].length;
        int len = r * c;
        int[] index = new int[len];
        // 先把所有元素按照顺序放入到数组中 因为题目中说 grid[i][j]均无重复 所以index的下标用grid[i][j]的话可以把排序也做了
        // index的值存的是下标

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                index[grid[i][j]] = getIndex(i, j);

            }
        }

        // 在使用并查集 随着i++ 就是时间的增加 把小于等于i的元素连起来
        // 只要左上角(0,0) 和右下角(n-1,n-1)相连了就返回当时的时间i
        UnionFind2 uf = new UnionFind2(len);
        //
        for (int i = 0; i < len; i++) {
            int x = index[i] / r;
            int y = index[i] % r;

            for (int[] d : directions) {
                int nextX = x + d[0];
                int nextY = y + d[1];

                if (0 <= nextX && nextX < r && 0 <= nextY && nextY < c && grid[nextX][nextY] <= i) {
                    uf.union(getIndex(nextX, nextY), index[i]);
                }

                if (uf.connected(0, len - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }


    public int getIndex(int x, int y) {
        return x * r + y;
    }

    @Test
    public void test1() {
        Assert.assertEquals(16, swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
    }
}

