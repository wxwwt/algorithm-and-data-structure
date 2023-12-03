package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class FindChampionII_2924 {


    public int findChampion(int n, int[][] edges) {
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            arr[edges[i][1]] = 1;
        }

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
                index = i;
            }
        }
        return count > 1 ? -1 : index;
    }


    @Test
    public void test() {
//        Assert.assertEquals(0, findChampion(new  int[][]{{0,1},{0,0}}));

        Assert.assertEquals(-1, findChampion(4, new int[][]{{0, 1}, {2, 0}, {2, 1}}));
        Assert.assertEquals(0, findChampion(3, new int[][]{{0, 1}, {1, 2}}));
        Assert.assertEquals(-1, findChampion(4, new int[][]{{0, 2}, {1, 3}, {1, 2}}));
        Assert.assertEquals(-1, findChampion(3, new int[][]{{0, 2}, {1, 2}, {3, 2}}));
        Assert.assertEquals(-1, findChampion(2, new int[][]{}));
        Assert.assertEquals(0, findChampion(1, new int[][]{}));
        Assert.assertEquals(-1, findChampion(3, new int[][]{}));
        Assert.assertEquals(-1, findChampion(3, new int[][]{{0, 1}}));
        Assert.assertEquals(0, findChampion(2, new int[][]{{0, 1}}));

//        Assert.assertEquals(-1, findChampion(3, new  int[][]{{0,2},{1,0},{2,1}}));


//        [[0,0],[1,0]]
    }
}
