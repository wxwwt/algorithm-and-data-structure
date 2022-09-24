package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2021/5/30 10:52
 */
public class PowerOfTwo_231 {

    /**
     * 这里要想到用位运算
     * 记录官网的两种位运算判断是否2次幂的方式
     * 1.  n & (n - 1) = 0，那么n就是2的幂
     * 举例： 3        111
     *       3-1 = 2  010
     *       结果      2  不等于0就不是2的幂
     *
     *       2        10
     *       2-1 = 1  01
     *       结果     0   等于0，是2的幂
     * 2.  n & (-n) = n ， 那么n就是2的幂。负数等于n的反码加一
     * 举例 3      111
     *      -3    001
     *      结果  001  不等于n，不是2的幂
     *
     *      2     10
     *      -2    10
     *      结果   10  等于n，是2的幂
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
       return n > 0 && (n & (n - 1)) == 0;

    }

    @Test
    public void test1() {
        Assert.assertFalse(isPowerOfTwo(3));
        Assert.assertFalse(isPowerOfTwo(5));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isPowerOfTwo(1));
        Assert.assertTrue(isPowerOfTwo(4));
        Assert.assertTrue(isPowerOfTwo(536870912));
    }

}