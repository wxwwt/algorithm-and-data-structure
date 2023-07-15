package com.algorithm.leetcode.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/7/9 10:21
 */
public class LCP_T03 {





    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
            int[][] dp = new int[n][2];
            for (int[] arr : dp) {
                Arrays.fill(arr, 1);
            }
//        Arrays.fill(dp, 1);
            // dp[i][0] 表示以nums1[i]结尾最大子数组的长度
        // dp[i][1] 表示以nums2[i]结尾最大子数组的长度
        int  max = 1;
        for (int i = 1; i < n; i++) {
            // 左边比较的nums是表示上一个选的值是nums1还是nums2
            if (nums1[i - 1] <= nums1[i]) {
                dp[i][0] = dp[i - 1][0] + 1;
            }

            if (nums2[i - 1] <= nums1[i]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
            }

            if (nums2[i - 1] <= nums2[i]) {
                dp[i][1] =  dp[i - 1][1] + 1;
            }

            if (nums1[i - 1] <= nums2[i]) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }




    @Test
    public void test1() {

        Assert.assertEquals(4, maxNonDecreasingLength(new int[]{1, 3, 2, 1}, new int[]{2, 2, 3, 4}));
        Assert.assertEquals(2, maxNonDecreasingLength(new int[]{8,7,4}, new int[]{13,4,4}));
        Assert.assertEquals(3, maxNonDecreasingLength(new int[]{11,7,7,9}, new int[]{19,19,1,7}));

        Assert.assertEquals(1, maxNonDecreasingLength(new int[]{1}, new int[]{1}));

    }
}