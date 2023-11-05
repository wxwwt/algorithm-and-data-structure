package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

public class LCP_368_2 {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int[] minA = new int[n];
        int[] minIndex = new int[n];
        int[] maxA = new int[n];
        int[] maxIndex = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                maxA[i] = max;
                maxIndex[i] = i;
            } else {
                maxA[i] = maxA[i+1];
                maxIndex[i] = maxIndex[i+1];
            }

            if (nums[i] < min) {
                min = nums[i];
                minA[i] = min;
                minIndex[i] = i;
            } else {
                minA[i] = minA[i+1];
                minIndex[i] = minIndex[i+1];
            }
        }

        int[] ans = new int[]{-1,-1};
        for (int i = 0 ; i < n ; i++) {
            if (i + indexDifference < n && Math.abs(nums[i] - maxA[i + indexDifference]) >= valueDifference) {
                return new int[]{i, maxIndex[i + indexDifference]};
            }

            if (i + indexDifference < n && Math.abs(nums[i] - minA[i + indexDifference]) >= valueDifference) {
                return new int[]{i, minIndex[i + indexDifference]};
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{0,3},findIndices(new int[]{5,1,4,1}, 2, 4) );
    }
}
