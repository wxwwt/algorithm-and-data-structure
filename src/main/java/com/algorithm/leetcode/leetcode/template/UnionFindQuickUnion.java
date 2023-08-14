package com.algorithm.leetcode.leetcode.template;

/**
 * @author scott
 * @date 2023/8/14 8:37
 */
public class UnionFindQuickUnion {

    int[] root;

    public UnionFindQuickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }


    public int find(int x) {
        while (root[x] != x) {
            return root[x] = find(x);
        }
        return x;
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            root[y] = xRoot;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }


}