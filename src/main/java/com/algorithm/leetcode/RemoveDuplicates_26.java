package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/26 21:33
 */
public class RemoveDuplicates_26 {

    public int removeDuplicates(int[] nums) {
        int s = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[s]) {
                nums[s + 1] = nums[i];
                s = s + 1;
            }
        }
        return s + 1;
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, removeDuplicates(new int[]{1,1,2}));
        Assert.assertEquals(5, removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}