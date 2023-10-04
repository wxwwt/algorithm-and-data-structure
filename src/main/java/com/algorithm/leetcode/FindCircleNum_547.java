package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author scott
 * @date 2023/8/7 22:55
 */
public class FindCircleNum_547 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }

        }
        Set<Integer> sum = new HashSet<>();
        for (int i : uf.root) {
            sum.add(i);
        }
        return sum.size();
    }

    class UnionFind {

        int[] root;

        UnionFind(int size) {
            root = new int[size];
            for (int i = 0 ; i < size; i++) {
                root[i] = i;

            }
        }


        public int find(int x) {
            return root[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (yRoot != xRoot) {
               for (int i = 0 ;i < root.length;i++) {
                   if (yRoot == root[i]) {
                    root[i] = xRoot;
                   }
               }

            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }


    @Test
    public void test1() {
        Assert.assertEquals(2 , findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        Assert.assertEquals(3, findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));

        Assert.assertEquals(3, findCircleNum(new int[][]        {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}}
        ));

    }
}