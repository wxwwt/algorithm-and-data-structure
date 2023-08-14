package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2023/8/13 10:20
 */
public class MinAbsoluteDifference1_7022 {

    /**
     * 一开始想到的是双指针，然后每个数去和所有符合条件的数字得到绝对值，在统计最小的那个值，
     * 但是会超时，时间复杂度是o(n^2)
     * @param nums
     * @param x
     * @return
     */
    public int minAbsoluteDifference1(List<Integer> nums, int x) {
        int min = Integer.MAX_VALUE;
        for (int i = nums.size() - 1; i > 0; i--) {
            int e = i - x;
            while (e >= 0) {
                min = Math.min(min, Math.abs(nums.get(i) - nums.get(e)));
                if (min == 0) {
                    return 0;
                }
                e--;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }




    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        int result = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = x ; i < n; i++) {
            set.add(nums.get(i - x));
            Integer ceiling = set.ceiling(nums.get(i));
            if (ceiling != null) {
                result = Math.min(result, Math.abs(nums.get(i) - ceiling));
            }

            Integer floor = set.floor(nums.get(i));
            if (floor != null) {
                result = Math.min(result, Math.abs(nums.get(i) - floor));
            }

        }
        return result;
    }

    @Test
    public void test1() {
//        Assert.assertEquals(0, minAbsoluteDifference(List.of(1), 0));
//        Assert.assertEquals(0, minAbsoluteDifference(List.of(4,3,2,4), 2));
        Assert.assertEquals(1, minAbsoluteDifference(List.of(5,3,2,10,15), 1));

    }
}