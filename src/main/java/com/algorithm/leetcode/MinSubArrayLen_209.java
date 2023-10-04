package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/19 22:28
 */
public class MinSubArrayLen_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int s = 0, sum = 0;
        int len = 0, result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                len = i - s + 1;
                result = Math.min(result, len);
                sum -= nums[s];
                s++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        Assert.assertEquals(1, minSubArrayLen(2, new int[]{1,4,4}));
        Assert.assertEquals(0, minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));


    }
}