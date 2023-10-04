package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @since 2020-04-23
 */
public class FindPivotIndex_724 {

    public int pivotIndex(int[] nums) {
        // 数组总和sum = leftSum + nums[i] + rightSum
        // leftSum = sum - nums[i] - rightSum
        // 2leftSum = sum - nums[i]
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 整型除法会有问题 所以用乘法
            if (2 * leftSum == sum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    @Test
    public void test1() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        Assert.assertEquals(3, pivotIndex(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3};
        Assert.assertEquals(-1, pivotIndex(nums));
    }

    @Test
    public void test3() {
        int[] nums = {-1, -1, -1, -1, -1, -1};
        Assert.assertEquals(-1, pivotIndex(nums));
    }

    @Test
    public void test4() {
        int[] nums = {-1, -1, 0, 0, -1, -1};
        Assert.assertEquals(2, pivotIndex(nums));
    }
}
