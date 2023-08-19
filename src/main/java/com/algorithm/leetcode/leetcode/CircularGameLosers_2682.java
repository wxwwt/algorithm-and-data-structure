package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/8/16 22:47
 */
public class CircularGameLosers_2682 {

    public int[] circularGameLosers(int n, int k) {
        if (n == 1) {
            return new int[]{};
        }
        int[] arr = new int[n];
        int next = 0;
        int i = 1;
        arr[next] = 1;
        while (arr[next] <= 1) {
             next = (next + i * k) % n;

             i++;
             arr[next]++;
        }


        if (n  - i + 1 == 0) {
            return new int[]{};
        }
        int[] r = new int[n  - i + 1];
        int z = 0;
        for (int j = 0 ;j < n ; j++) {
            if (arr[j] == 0) {
                r[z++] = j +1;
            }
        }
        return r;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{2}, circularGameLosers(3,2));
        Assert.assertArrayEquals(new int[]{}, circularGameLosers(2,1));
        Assert.assertArrayEquals(new int[]{4,5}, circularGameLosers(5,2));
        Assert.assertArrayEquals(new int[]{2,3,4}, circularGameLosers(4,4));
        Assert.assertArrayEquals(new int[]{}, circularGameLosers(1,1));
    }
}