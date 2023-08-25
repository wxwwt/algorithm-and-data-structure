package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2023/8/20 10:18
 */
public class MaximizeTheProfit_2830 {

    public int maximizeTheProfit1(int n, List<List<Integer>> offers) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (List<Integer> offer : offers) {
            int end = offer.get(1);
            List<List<Integer>> list = map.getOrDefault(end, new ArrayList<>());
            list.add(offer);
            map.put(end, list);
        }
        // dp[i]表示销售前i所房屋所能获得的最大利润
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (List<Integer> offer : map.getOrDefault(i - 1, new ArrayList<>())) {
                int start = offer.get(0);
                int gold = offer.get(2);
                dp[i] = Math.max(dp[i], (start > 0 ? dp[start] : 0) + gold);
            }
        }
        return dp[n];
    }

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
       // 将offter分组 用end作为分组条件
        List<int[]>[] arr = new ArrayList[n];
        Arrays.setAll(arr, e -> new ArrayList<>());
        for (List<Integer> offer : offers) {
            arr[offer.get(1)].add(new int[]{offer.get(0), offer.get(2)});

        }

        int[] dp = new int[n + 1];
        // dp是以i结尾 能卖出房屋的最大值
        for (int end = 0; end < n ; end++) {
            // 如果选了end结尾的房子
            dp[end + 1] = dp[end];
            // 如果没有选end结尾的房子 就遍历以end结尾的所有数组 找到最大值 然后选和没选里面取最大值
            for (int[] t : arr[end]) {
                dp[end + 1] = Math.max(dp[end + 1] , dp[t[0]] + t[1]);
            }
        }
        return dp[n];
    }


    @Test
    public void test1() {
        Assert.assertEquals(3, maximizeTheProfit(5, List.of(List.of(0,0,1), List.of(0,2,2), List.of(1,3,2))));
    }
}