package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/2 10:31
 */
public class LongestAlternatingSubarray_2706 {


    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int result = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0 && nums[j] <= threshold) {

                int k = j;
                int temp = 1;
                while (k + 1 < nums.length && nums[k] % 2 != nums[k + 1] % 2 && nums[k + 1] <= threshold) {
                    temp++;
                    k++;
                }
                result = Math.max(result, temp);
            }


        }

        return result;
    }


    @Test
    public void test1() {

        Assert.assertEquals(3, longestAlternatingSubarray(new int[]{3,2,5,4}, 5));
        Assert.assertEquals(3, longestAlternatingSubarray(new int[]{2,3,4,5}, 4));

    }

}