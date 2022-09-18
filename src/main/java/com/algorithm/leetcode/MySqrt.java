package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/9/17 23:36
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int max = x, min = 0, mid = min + (max - min) / 2;
        while (min <= max) {
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                // 如果要求的平方小于x 就找更大的
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            mid = min + (max - min) / 2;
        }
        return max;
    }

    @Test
    public void test1() {
        System.out.println(Integer.MAX_VALUE);
//        Assert.assertEquals(2, mySqrt(4));
//        Assert.assertEquals(2, mySqrt(8));
//        Assert.assertEquals(0, mySqrt(0));
//        Assert.assertEquals(1, mySqrt(1));
//        Assert.assertEquals(3, mySqrt(9));
        Assert.assertEquals(46339, mySqrt(2147395599));

    }
}