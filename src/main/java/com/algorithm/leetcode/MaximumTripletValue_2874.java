package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class MaximumTripletValue_2874 {

    public long maximumTripletValue(int[] nums) {

        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];

        long ans = 0;
        l[0] = 0;
        int lMax = nums[0], rMax = Integer.MIN_VALUE;
        int maxDiff = 0;
        for (int i = 1; i < n; i++) {
            // 找到最小值
            if (nums[i] > lMax) {
                lMax = nums[i];
            }
            maxDiff = Math.max(lMax - nums[i], maxDiff);
            l[i] = maxDiff;

        }

        for (int i = n - 1; i >= 0; i--) {

            if (nums[i] > rMax) {
                rMax = nums[i];

            }
            r[i] = rMax;
        }

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max((long) l[i] * (long) r[i + 1], ans);
        }
        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(77, maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        Assert.assertEquals(133, maximumTripletValue(new int[]{1, 10, 3, 4, 19}));

        Assert.assertEquals(0, maximumTripletValue(new int[]{1, 2, 3}));
        Assert.assertEquals(0, maximumTripletValue(new int[]{2, 3, 1}));

    }
}
