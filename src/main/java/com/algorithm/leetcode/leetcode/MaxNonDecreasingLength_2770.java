package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/7/9 10:21
 */
public class MaxNonDecreasingLength_2770 {





    public int maxNonDecreasingLength1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 定义dp[i][0] 是nums1[i]最大非递减数组长度 dp[i][1] 是nums2[i]最大非递减数组长度
        int[][] dp = new int[n][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }

        int max = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] >= nums1[i - 1]) {
                dp[i][0] = dp[i -1][0] + 1;
            }

            if (nums1[i] >= nums2[i - 1]) {
                dp[i][0] = Math.max(dp[i][0], dp[i -1][1] + 1);
            }

            if (nums2[i] >= nums1[i - 1]) {
                dp[i][1] = dp[i -1][0] + 1;
            }

            if (nums2[i] >= nums2[i - 1]) {
                dp[i][1] = Math.max(dp[i][1], dp[i -1][1] + 1);
            }

            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }

    /**
     * 上面的方法空间负责度是O(n) , 但是我们可以看到所有的值其实只依赖于上一个值，所以
     * 可以优化成只用两个变量存储上一个的值，时间复杂度不变还是O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 定义dp[i][0] 是nums1[i]最大非递减数组长度 dp[i][1] 是nums2[i]最大非递减数组长度
        int v1 =1, v2 =1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int cur1 = 1, cur2 =1;
            if (nums1[i] >= nums1[i - 1]) {
                cur1 = v1 + 1;
            }

            if (nums1[i] >= nums2[i - 1]) {
               cur1 = Math.max(cur1, v2 + 1);
            }

            if (nums2[i] >= nums1[i - 1]) {
               cur2 = v1 + 1;
            }

            if (nums2[i] >= nums2[i - 1]) {
               cur2 = Math.max(cur2, v2 + 1);
            }

            v1 = cur1;
            v2 = cur2;
            max = Math.max(max, Math.max(cur1, cur2));

        }
        return max;
    }




    @Test
    public void test1() {
        Assert.assertEquals(2, maxNonDecreasingLength(new int[]{3,19,13,19}, new int[]{20,18,7,14}));

        Assert.assertEquals(4, maxNonDecreasingLength(new int[]{1, 3, 2, 1}, new int[]{2, 2, 3, 4}));
        Assert.assertEquals(2, maxNonDecreasingLength(new int[]{8,7,4}, new int[]{13,4,4}));
        Assert.assertEquals(3, maxNonDecreasingLength(new int[]{11,7,7,9}, new int[]{19,19,1,7}));

        Assert.assertEquals(1, maxNonDecreasingLength(new int[]{1}, new int[]{1}));




    }
}