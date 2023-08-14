package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2023/8/13 10:20
 */
public class MaxSum_6939 {

    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map  = new HashMap<>();
        for (int i = 0 ;i < nums.length;i++) {
            int mod = nums[i];
            int max  = Integer.MIN_VALUE;
            while (mod != 0) {
               max = Integer.max(max, mod % 10);
                mod = mod / 10;
            }


             List<Integer> indexLsit =   map.getOrDefault(max, new ArrayList<>());
          indexLsit.add(nums[i]);
          map.put(max, indexLsit);
        }

        int max = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int n = list.size();
            if (list.size() >= 2) {
                Collections.sort(list);
                max = Math.max(max, list.get(n - 1) + list.get(n-2));
            }
        }
        return max;
    }

    @Test
    public void test1() {
        Assert.assertEquals(165, maxSum(new int[]{84,91,18,59,27,9,81,33,17,58}));
        Assert.assertEquals(-1, maxSum(new int[]{1,2,3,4}));
        Assert.assertEquals(88, maxSum(new int[]{51,71,17,24,42}));
    }
}