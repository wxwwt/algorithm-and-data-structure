package com.algorithm.completition;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

public class LCP_370_4 {

    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        long sum = nums[0];
        // 表示以nums[i]结尾的最大
        dp[0] = nums[0];
        int[] max = new int[n];
        max[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[max[i-1]]) {
                max[i] = i;
            } else {
                max[i] = max[i-1];
            }
        }

        for (int i = 1; i < n; i++) {
            int j = max[i -1];
            if (nums[i] - nums[j] >=  i-j) {
                dp[i] = Math.max(dp[j] + nums[i], nums[i]);
            } else {
                while (j > 0 && nums[i] - nums[j] < i - j) {
                    j--;
                }

                if (nums[i] - nums[j] > i - j) {
                    dp[i] = Math.max(dp[j] + nums[i], nums[i]);
                } else {
                    dp[i] = nums[i];
                }

            }
            sum = Math.max(dp[i], sum);
        }
        return sum;
    }


    @Test
    public void test() {
        Assert.assertEquals(14, maxBalancedSubsequenceSum(new int[]{3,3,5,6}));
        Assert.assertEquals(13, maxBalancedSubsequenceSum(new int[]{5,-1,-3,8}));
        Assert.assertEquals(-1, maxBalancedSubsequenceSum(new int[]{-2,-1}));

        Assert.assertEquals(65, maxBalancedSubsequenceSum(new int[]{34,34,32,33}));
//        []

    }
}
