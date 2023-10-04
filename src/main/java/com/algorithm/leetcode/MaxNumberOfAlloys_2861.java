package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class MaxNumberOfAlloys_2861 {

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int minStock = stock.stream().min(Comparator.naturalOrder()).get();
        int ans = 0;
        for (int i = 0; i < composition.size(); i++) {
            int r = budget + minStock + 1;
            int mid, l = 0;
            int num = 0;
            while (l + 1 < r) {
                mid = (r - l) / 2 + l;

                // 如果预算够 就增加数量
                if (isEnough(budget, composition.get(i), stock, mid, cost)) {
                    l = mid;
                    num = mid;
                } else {
                    // 如果预算不够 就减少数量
                    r = mid;
                }

            }
            ans = Math.max(num, ans);
        }
        return ans;
    }

    private static boolean isEnough(int budget, List<Integer> composition, List<Integer> stock, int mid, List<Integer> cost) {
        long money = 0;
        for (int j = 0; j < composition.size(); j++) {
            // 如果当前数量的条件下要用多少材料 超过了库存 就要花钱
            long need = composition.get(j) * mid;
            if (need > stock.get(j)) {
                money += (need - stock.get(j)) * cost.get(j);
                if (money > budget) {
                    return false;
                }
            }
        }
        return true;
    }


    @Test
    public void test() {
        Assert.assertEquals(2, maxNumberOfAlloys(3, 2, 15, List.of(List.of(1, 1, 1), List.of(1, 1, 10)), List.of(0, 0, 0), List.of(1, 2, 3)));
        Assert.assertEquals(5, maxNumberOfAlloys(3, 2, 15, List.of(List.of(1, 1, 1), List.of(1, 1, 10)), List.of(0, 0, 100), List.of(1, 2, 3)));
        Assert.assertEquals(2, maxNumberOfAlloys(2, 3, 10, List.of(List.of(2, 1), List.of(1, 2), List.of(1, 1)), List.of(1, 1), List.of(5, 5)));
        Assert.assertEquals(54, maxNumberOfAlloys(1, 7, 48, List.of(List.of(1), List.of(5), List.of(9), List.of(6), List.of(4), List.of(2), List.of(4)), List.of(6), List.of(1)));
    }

}
