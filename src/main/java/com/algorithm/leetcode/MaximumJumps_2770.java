package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/22 10:07
 */
public class MaximumJumps_2770 {

    public int maximumJumps(int[] nums, int target) {

        // 定义dp[i] 是以i结尾的最大跳跃次数
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {

                if (Math.abs(nums[i] - nums[j]) <= target) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            // 如果向前遍历完 还是0 说明找不到符合条件的值 设置为-1
            if (max == 0) {
                dp[i] = -1;
            } else {
                dp[i] = max;
            }
        }
        return dp[nums.length - 1];
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2));
        Assert.assertEquals(5, maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 3));
        Assert.assertEquals(-1, maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 0));

    }
}