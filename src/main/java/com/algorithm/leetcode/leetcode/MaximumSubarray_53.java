package com.algorithm.leetcode.leetcode;

/**
 * @author scott
 * @since 2019-10-22
 */
public class MaximumSubarray_53 {

    public static int maxSubArray(int[] nums) {
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

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * dp[i] = dp[i - 1] + num[i];  num[i] >= 0
     * dp[i] = dp[i - 1];           num[i] < 0
     *
     * dp[i] = (1) dp[i]    num.len = 1
     *         (2) dp[]     dp[i] = num[i]是最大和的时候,当num.len > 1的时候必然有一个数是正数,因为如果是0,加上正数或者0的时候才有两位
     *                                                        如果是负数,加上0最大和就是一位数0,加上正数可以达到两位数的最大和,加上负数是不能会有最大和的,和反而变小了,
     *                                                         所以当nums最大和的长度是大于1的,必然有一个数是正数.
     *         有了这个结论以后我们令num[i] > 0
     *         dp[i] = dp[i - 1] + num[i]  当dp[i - 1] >=0
     *         dp[i] = num[i]              当dp[i - 1] < 0
     *         所以状态转移方程式三部分构成
     *         (1) dp[i]    num.len = 1
     *         (2) dp[i] = dp[i - 1] + num[i]  当dp[i - 1] >=0,len > 2
     *         (3) dp[i] = num[i]              当dp[i - 1] < 0 len > 2
     *         然后发现1和3其实是可以合并的
     *         所以变成了
     *         (1) dp[i] = num[i]  dp[i - 1] < 0
     *         (2) dp[i] = dp[i - 1] + num[i]
     *
     *
     *         */
}
