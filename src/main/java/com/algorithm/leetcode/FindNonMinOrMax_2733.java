package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/28 8:15
 */
public class FindNonMinOrMax_2733 {

    public int findNonMinOrMax(int[] nums) {
        int min = nums[0] , max = nums[0], temp =-1;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }

            if (i < min) {
                min = i;
            }


        }

        for (int j : nums) {
            if (j != min && j != max) {
                temp = j;
            }
        }
        return temp;
    }

    @Test
    public void test1() {
        Assert.assertEquals(2,findNonMinOrMax(new int[]{3,2,1,4}));
        Assert.assertEquals(-1,findNonMinOrMax(new int[]{1,2}));
    }
}