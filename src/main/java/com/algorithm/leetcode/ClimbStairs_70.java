package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/2/19 9:31
 */
public class ClimbStairs_70 {


    /**
     * 掌握了滚动数组，这种递推的题目基本都是一样的解法
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int a = 1, b = 2, c = 3;
        for (int i = 3; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, climbStairs(3));
        Assert.assertEquals(5, climbStairs(4));
    }
}