package com.algorithm.leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author scott
 * @date 2023/8/25 8:48
 */
public class MaxTaxiEarnings_2008 {

    public long maxTaxiEarnings(int n, int[][] rides) {
        List<int[]>[] groups = new ArrayList[n];
        Arrays.setAll(groups, item -> new ArrayList<>());
        for (int[] ride : rides) {
           groups[ ride[1]].add(new int[]{ride[0], ride[2]});
        }

        long ans = 0L;
        int[] dp = new int[n + 1];
        for(int end = 0; end < n; end++) {
            // 以i结尾的最大金额
            // 选择不接乘客i
            dp[end + 1] = dp[end];
            for (int[] group : groups[end]) {
                // 选择接上乘客i 就找到以end结尾的乘客中能接到的最大值
            }
        }
        return ans;
    }
}