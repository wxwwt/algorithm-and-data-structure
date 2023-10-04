package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/8/19 20:06
 */
public class TrappingRainWater_42 {

    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i -1], height[i - 1]);
        }

        for (int i = n - 2; i > 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int r = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(left[i], right[i]) ;

            if (min > height[i]) {
                r = r + (min - height[i]);
            }


        }
        return r;
    }


    @Test
    public void test1() {
//        Assert.assertEquals(6 , trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        Assert.assertEquals(0, trap(new int[]{1}));
        Assert.assertEquals(9, trap(new int[]{4,2,0,3,2,5}));
    }
}