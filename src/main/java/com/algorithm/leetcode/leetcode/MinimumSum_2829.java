package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author scott
 * @date 2023/8/20 10:18
 */
public class MinimumSum_2829 {

    public int minimumSum(int n, int k) {
        Map<Integer, Integer> set = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            set.put(i + 1, 0);
            max = Math.max(i + 1, max);
        }


        List<Integer> list = set.keySet().stream().map(item -> item).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> entry : set.entrySet()) {

            int i = entry.getKey();

            if (k - i > 0) {
                Integer t = k - i;
                if (t > i && set.containsKey(t)) {

                    max++;
                    if (k - max > 0) {
                        while (set.containsKey(k - max)) {
                            max++;
                        }
                    }

                        list.remove(t);
                        list.add(max);



                }
            }

        }


        int ans = 0;
        for (Integer entry : list){

                ans += entry;

        }
        return ans;
    }


    @Test
    public void test1() {
        Assert.assertEquals(18, minimumSum(5, 4));
        Assert.assertEquals(3, minimumSum(2, 6));
        Assert.assertEquals(8, minimumSum(3, 5));

    }
}