package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/7/9 10:20
 */
public class MaximumBeauty_2779 {

    public int maximumBeauty(int[] nums, int k) {
        int left = 0, right = 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length;i++) {
            while (right <= nums.length - 1 && nums[right] - nums[left] <= 2 * k) {
                right++;
            }

                left++;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }


    @Test
    public void test1() {
        Assert.assertEquals(3, maximumBeauty(new int[]{4,6,1,2}, 2));
      Assert.assertEquals(4, maximumBeauty(new int[]{1,1,1,1}, 10));
        Assert.assertEquals(2, maximumBeauty(new int[]{5,57,46}, 15));
        Assert.assertEquals(3, maximumBeauty(new int[]{43,86,33,18}, 23));
        Assert.assertEquals(2, maximumBeauty(new int[]{81,76,40}, 5));


    }
}