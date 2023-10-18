package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

public class LCP_367_4 {

    public int[][] constructProductMatrix(int[][] grid) {
        int c = grid.length;
        int r = grid[0].length;
        int[][] ans = new int[c][r];
        long t = 1;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
               long x = t * grid[i][j];
                t = x > 12345 ? x % 12345 : x;
            }
        }

        for (int i = 0; i < c ; i++) {
            for (int j = 0; j < r; j++) {
               long x = t / grid[i][j];
                ans[i][j] = (int) (x > 12345 ? x % 12345 : x);
            }
        }
        return ans;
    }

    @Test
    public void test() {

//        Assert.assertEquals("1", shortestBeautifulSubstring("001", 1));
//
//        Assert.assertEquals("11101111001", shortestBeautifulSubstring("1100001110111100100", 8));
//        Assert.assertEquals("11001", shortestBeautifulSubstring("100011001", 3));
//        Assert.assertEquals("11", shortestBeautifulSubstring("1011", 2));
//        Assert.assertEquals("", shortestBeautifulSubstring("000", 3));
    }
}
