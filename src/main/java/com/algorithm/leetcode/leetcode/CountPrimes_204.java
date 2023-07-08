package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/7/5 21:46
 */
public class CountPrimes_204 {


    public int countPrimes(int n) {
            int[] arr = new int[n + 1];
            // 默认1是质数 0是合数
            Arrays.fill(arr, 1);
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (arr[i] == 1) {
                    count++;
                    for (int j = i * 2; j < n; j = j + i) {
                        arr[j] = 0;
                    }
                }
            }
            return count;
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, countPrimes(10));
        Assert.assertEquals(0, countPrimes(0));
        Assert.assertEquals(0, countPrimes(1));
    }

}