package com.algorithm.leetcode.completition;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/2 11:04
 */
public class ContinuousSubarrays_2762 {


    public long continuousSubarrays(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }


        int result = 0;
        for (int j = 0; j < nums.length; j++) {
            int max = nums[j];
            int min = nums[j];
            result++;
            for (int i = j + 1; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);

                if (Math.abs(max - min) > 2) {
                    break;
                }

                result++;
            }
        }



        return result;
    }



    @Test
    public void test1() {
        Assert.assertEquals(8, continuousSubarrays(new int[]{5, 4, 2, 4}));
    }
}