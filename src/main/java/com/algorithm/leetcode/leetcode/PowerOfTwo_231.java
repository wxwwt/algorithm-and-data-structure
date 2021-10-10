package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2021/5/30 10:52
 */
public class PowerOfTwo_231 {

    public boolean isPowerOfTwo(int n) {

        if (n == 1) {
            return true;
        }
        while (true) {
            // 奇数直接false
            if (n % 2 == 1) {
                return false;
            } else {
            // 偶数除以2 在判断是不是已经是2了
                n = n / 2;
                if (n == 2) {
                    return true;
                }
            }
        }
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