package com.algorithm.leetcode;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2023/8/30 8:15
 */
public class JobScheduling_1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        TreeMap<Integer, Integer> valueMap = new TreeMap<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List list = map.getOrDefault(endTime[i], new ArrayList<>());
            list.add(new int[]{startTime[i], profit[i]});
            map.put(endTime[i], list);
        }

        Arrays.sort(endTime);
        int ans = 0;
        for (int end = 0; end < n - 1; end++) {
            // 不选以end结尾的这个元素
            int finalEnd = end;

            if (valueMap.get(endTime[end]) == null) {
                int tMax = 0;
              for (var array :  map.getOrDefault(endTime[end], new ArrayList<>())) {
                   tMax = Math.max(array[1], tMax);
              }
                valueMap.put(endTime[end], tMax);
            }

            valueMap.put(endTime[end + 1], valueMap.get(endTime[end]));

//          List<int[]> tMap = map.get(end);
//          if (tMap != null) {
//
//          }
            for (var array : map.getOrDefault(endTime[end + 1], new ArrayList<>())) {
                // 选了当前工作的最大值
                int max = Math.max(valueMap.get(endTime[end + 1]), valueMap.floorKey(array[0]) != null ? valueMap.get(valueMap.floorKey(array[0])) + array[1] :  array[1]);
                valueMap.put(endTime[end + 1], max);
                ans = Math.max(ans, max);
            }

        }
        return ans;
    }

    @Test
    public void test1() {
        Assert.assertEquals(120, jobScheduling(new int[]{1,2,3,3},new int[]{3,4,5,6},new int[]{50,10,40,70}));
        Assert.assertEquals(150, jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
        Assert.assertEquals(20, jobScheduling(new int[]{24,24,7,2,1,13,6,14,18,24}, new int[]{27,27,20,7,14,22,20,24,19,27}, new int[]{6,1,4,2,3,6,5,6,9,8}));

    }
}