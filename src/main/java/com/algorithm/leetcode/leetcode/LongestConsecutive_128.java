package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author scott
 * @date 2023/8/3 22:12
 */
public class LongestConsecutive_128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int  max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 从起点开始
            if (!set.contains(nums[i] - 1)) {
                int temp = nums[i];
                int r = 1;

                while (set.contains(++temp)) {
                    r++;
                }
                max = Math.max(r, max);
            }
        }
        return max;
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, longestConsecutive(new int[]{100,4,200,1,3,2}));
        Assert.assertEquals(9, longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        Assert.assertEquals(0, longestConsecutive(new int[]{}));
        Assert.assertEquals(1, longestConsecutive(new int[]{1}));
    }
}