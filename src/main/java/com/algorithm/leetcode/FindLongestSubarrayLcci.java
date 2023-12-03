package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarrayLcci {


    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int[] d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            d[i + 1] = d[i] + (array[i].charAt(0) >> 6 & 1) * 2 - 1;
        }

        int max = 0, fIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int t = map.getOrDefault(d[i], -1);
            if (t < 0) {
                // 说明是第一次出现
                map.put(d[i], i);
            } else {
                // 有相同的 说明找到字母和数字相等的子数组了，对比一下下标，找到最大的那个
                if (i - t > max) {
                    max = i - t;
                    fIndex = t;
                }
            }
        }

        if (max == 0) {
            return new String[0];
        }

        String[] ans = new String[max];
        System.arraycopy(array, fIndex, ans, 0, max);
        return ans;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new String[]{"A","1"}, findLongestSubarray(new String[]{"A","1"}));
//        Assert.assertArrayEquals(new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7"}, findLongestSubarray(new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"}));

    }


}
