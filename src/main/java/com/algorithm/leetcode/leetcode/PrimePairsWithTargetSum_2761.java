package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2023/7/2 10:57
 */
public class PrimePairsWithTargetSum_2761 {

    static Set<Integer> set = new HashSet<>();

    static {
        findPrime(1000_000);
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
             if (set.contains(i) && set.contains(n - i)) {
                 result.add(List.of(i, n - i));
             }
        }
        return result;
    }


    public static void findPrime(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        for (int i = 2; i < n; i++) {
            // 等于1是质数
            if (arr[i] == 1) {
                for (int j = i * 2; j < n; j = j + i) {
                    arr[j] = 0;
                }
            }
        }


        for (int i = 2; i < n; i++) {
            if (arr[i] == 1) {
                set.add(i);
            }
        }
    }

    @Test
    public void test1() {
        Assert.assertEquals(List.of(List.of(3, 7), List.of(5, 5)), findPrimePairs(10));
        Assert.assertEquals(new ArrayList<>(), findPrimePairs(2));
    }
}