package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/2/15 22:53
 */
public class NTribonacciNumber_1137 {

    /**
     * 使用滚动数组完成
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        int a = 0, b = 1, c = 1, d = 2;
        for (int i = 3; i < n; i++) {
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
        return d;
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, tribonacci(0));
        Assert.assertEquals(2, tribonacci(3));
        Assert.assertEquals(4, tribonacci(4));
        Assert.assertEquals(1389537, tribonacci(25));
        Assert.assertEquals(2082876103, tribonacci(37));
    }
}