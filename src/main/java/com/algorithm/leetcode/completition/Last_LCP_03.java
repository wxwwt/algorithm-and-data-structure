package com.algorithm.leetcode.completition;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/22 22:27
 */
public class Last_LCP_03 {

    public long maxScore(int[] nums, int x) {
        int[][] dp = new int[nums.length][2];

        int mIndex = 0;
        int j, o;
        if ((nums[0] & 1) == 0) {
            o = 0;
            j = -1;
            dp[0][0] = nums[0];
        } else {
            o = -1;
            j = 0;
            dp[0][1] = nums[0];
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 当前是偶数
            int temp1 = 0, temp2 = 0;
            if ((nums[i] & 1) == 0) {
                if (o > -1) {
                    temp1 = dp[o][0] + nums[i];

                }

                if (j > -1) {
                    temp2 = dp[j][1] + nums[i] - x;
                }
                dp[i][0] = Math.max(Math.max(temp1, temp2), nums[i]);
                if (o < 0 || dp[i][0] > dp[o][0]) {
                    o = i;
                }

            } else {
                if (o > -1) {
                    temp1 = dp[o][0] + nums[i] - x;

                }

                if (j > -1) {
                    temp2 = dp[j][1] + nums[i];
                }
                dp[i][1] = Math.max(Math.max(temp1, temp2), nums[i]);

                if (j < 0 || dp[i][1] > dp[j][1]) {
                    j = i;
                }
            }


            max = Math.max(Math.max(dp[i][0], dp[i][1]), max);
        }
        return max;
    }

    @Test
    public void test1() {
        Assert.assertEquals(470, maxScore(new int[]{8, 50, 65, 85, 8, 73, 55, 50, 29, 95, 5, 68, 52, 79}, 74));
//        Assert.assertEquals(13, maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5));
//        Assert.assertEquals(20, maxScore(new int[]{2, 4, 6, 8}, 3));

    }


}