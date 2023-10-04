package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author scott
 * @date 2023/2/5 10:45
 */
public class FibonacciNumber_509 {

    /**
     * 解法一：递归
     * @param n
     * @return
     */
    public int fib(int n) {
        int[] dp = new int[n];
        if (n < 2) {
            return n;
        }

        if (dp[n - 1] != 0) {
            return dp[n - 1];
        } else {
            int value = fib(n - 1) + fib(n - 2);
            dp[n - 1] = value;
            return value;
        }

    }

    /**
     * 解法2：滚动数组，因为一直是使用fn fn-1 fn-2，
     * 就用三个变量，一直往右边前进
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1, c = 1;
        for (int i = 2; i < n; i++) {
             a = b;
             b = c;
             c = a + b;
        }
        return c;
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, fib2(4));
    }
}