package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @since 2019-10-22
 */
public class MaximumSubarray_53 {

    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int temp = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(temp + nums[i], nums[i]);
            max = Math.max(temp, max);
        }
        return max;
    }

    @Test
    public void test1() {
        System.out.println(maxSubArray1(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray2(new int[]{5,4,-1,7,8}));
    }

    @Test
    public void test2() {
        System.out.println(maxSubArray1(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray2(new int[]{5,4,-1,7,8}));
    }

    /**
     * 两种方式都是采用动态规划
     * 第一种方式是用一个dp的数组存储了每个下标上的相加的值，最后算出dp数组中最大的那个值
     * 前一个数是小于零的就不进行相加，db[i] = nums[i] (dp[i- 1] < 0)
     * 前一个数是大于等于0的就相加 dp[i] = dp[i + 1] + nums (dp[i - 1] >= 0)
     * 状态转移方程：
     * dp[i] = nums[i] (dp[i- 1] < 0)
     *         dp[i + 1] + nums (dp[i - 1] >= 0)
     * 第二种方式也是动态规划
     * 只是因为我们只需要计算出最大值，temp的值在一直被新的值覆盖，时间复杂度没有变化，但是空间复杂度下降到了o(1)
     **/
}
