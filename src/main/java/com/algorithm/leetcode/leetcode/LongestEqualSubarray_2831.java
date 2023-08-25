package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scott
 * @date 2023/8/20 10:18
 */
public class LongestEqualSubarray_2831 {


    public int longestEqualSubarray(List<Integer> nums, int k) {
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxLength = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (right = 0; right < nums.size(); right++) {
            int num = nums.get(right);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, countMap.get(num));

            while (right - left + 1 - maxFreq > k) {
                countMap.put(nums.get(left), countMap.get(nums.get(left)) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, maxFreq);
        }
        return maxLength;
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, longestEqualSubarray(List.of(1, 3, 2, 3, 1, 3), 3));
        Assert.assertEquals(1, longestEqualSubarray(List.of(1, 2, 1), 0));
        Assert.assertEquals(4, longestEqualSubarray(List.of(1, 1, 2, 2, 1, 1), 4));
        Assert.assertEquals(4, longestEqualSubarray(List.of(1, 1, 2, 2, 1, 1), 2));
        Assert.assertEquals(1, longestEqualSubarray(List.of(1, 2), 1));
        Assert.assertEquals(1, longestEqualSubarray(List.of(1), 1));
        Assert.assertEquals(1, longestEqualSubarray(List.of(2, 1), 0));

    }
}