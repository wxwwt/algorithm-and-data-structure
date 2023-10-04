package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/7/22 22:27
 */
public class IsGood_6930 {

    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }

        }
        return nums[nums.length -1] == nums.length -1;
    }

    @Test
    public void test1() {
        Assert.assertTrue(isGood(new int[]{1, 3, 3, 2}));
    }
}