package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 按位与最大的最长子数组
 *
 * @author scott
 * @date 2022/9/25 10:46
 */
public class LongestSubarrayWithMaximumBitwiseAND_6189 {

    /**
     * 这道题最大的坑点是是没看懂题目的意思。。。
     * 其实不用管什么按位与，意思就是求数组最大值的最长连续子序列。
     * 我以为是求最大值出现了多少次，题目没做出来，后来看讨论才明白这个题目的意思，无语了。
     *
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (l < nums.length && r < nums.length) {
            if (nums[r] == nums[l]) {
                count++;
                if (map.containsKey(nums[l])) {
                    // 原来已经出现过这个值了 map就放最大值
                    int tempMax = Math.max(map.get(nums[l]), count);
                    map.put(nums[l], tempMax);
                } else {
                    // 没出现过就放当前统计的count
                    map.put(nums[l], count);
                }
                max = Math.max(max, nums[l]);
                r++;
            } else {
                // 不连续的情况
                l = r;
                count = 0;
            }
        }
        return map.get(max);
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, longestSubarray(new int[]{1, 0, 2, 3, 3, 1, 3}));
        Assert.assertEquals(1, longestSubarray(new int[]{96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 279979}));
        Assert.assertEquals(3, longestSubarray(new int[]{378034, 378034, 378034}));
        Assert.assertEquals(1, longestSubarray(new int[]{2}));
    }
}