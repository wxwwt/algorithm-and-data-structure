package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/2/26 22:25
 */
public class HouseRobber_198 {


    /**
     * 解法一：
     * 使用动态规划
     * 设dp[i]选择了第i个元素后的最大值, 先看下有没有什么规律
     * dp[0] = nums[0]
     * dp[1] = nums[1]
     * dp[2] = nums[2] + nums[0]  选择了第3个元素
     * dp[3] = nums[3] + Max(dp[1], dp[0])
     * dp[4] = nums[4] + Max(dp[2], dp[1])
      大致写一下，状态转移方程
      dp[i] = {nums[i] + Max(dp[i - 2], dp[i - 3])  | i > 2 }

     最后最大的值，应该是dp[i]里面最大的那个值
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }


        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        int max = Math.max(Math.max(dp[0], dp[1]), dp[2]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            max = Math.max(dp[i] , max);
        }
        return max;
    }

    /**
     * 解法二：
     * 动态规划, 但是dp的含义不一样
     * dp[i]表示前i间房，能偷到的最大金额
     * 边界条件：
     * dp[0] = nums[0]
     * dp[1] = max(nums[0], nums[1])
     * dp[i] = nums[i] + dp[i-2]  | 选择了第i间房的时候，就不能先i-1，所以是选了的nums[i] + dp[i-2]
     *         dp[i-1]            | 不选择第i间房的时候
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    /**
     * 官方题解：方法2升级为滚动数组，降低空间复杂度到O(1)
     * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }




    @Test
    public void test1() {
//        Assert.assertEquals(4,  rob(new int[]{1,2,3,1}));
//        Assert.assertEquals(12, rob(new int[]{2,7,9,3,1}));
//        Assert.assertEquals(0,  rob(new int[]{0}));
//        Assert.assertEquals(1,  rob(new int[]{0,1}));
        Assert.assertEquals(3,  rob(new int[]{1,2,1,1}));
    }
}