package com.algorithm.leetcode.leetcode;

/**
 * @author scott
 * @since 2019-10-22
 */
public class MaximumSubarray_53 {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int item : nums) {
            if (item >= 0) {

            } else {
                res += item;
            }
        }
        return res;
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
     *         (3) dp[i] = num[i]              当dp[i - 1] < 0
     *         */
}
