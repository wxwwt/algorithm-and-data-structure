package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LCP_368_3 {

//    public int minGroupsForValidAssignment1(int[] nums) {
//        int n = nums.length;
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        int ans = 0;
//        Map<Integer, Integer> countMap = new HashMap<>();
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            int count =  countMap.getOrDefault(nums[i], 0);
//            count++;
//            countMap.put(nums[i], count);
//            if (count < min) {
//                min = count;
//            }
//
//            if (count > max) {
//                max = count;
//            }
//        }
//
//        ans = countMap.size();
//        List<Integer> list = new ArrayList<>(countMap.values());
//        Collections.sort(list);
//        int m = list.size();
//        for (int i = m -1 ;i >=0 ;i--) {
//           int count = list.get(m - 1);
//           while () {
//
//           }
//           if (count % (min + 1) == 0) {
//               ans += (count / (min + 1));
//           } else if ( count / (min + 1) == min) {
//               ans += count / list.get(1);
//           } else {
//
//           }
//        }
//
//        for (int i = 0; i < n; i++) {
//            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
//            if (list.isEmpty()) {
//                list.add(1);
//            } else {
//               int count =  list.get(list.size() - 1);
//               if (count < 2) {
//                   count++;
//                   list.set(list.size() - 1, count);
//               } else {
//                   list.add(1);
//               }
//
//            }
//            map.put(nums[i], list);
//        }
//
////       for(Integer count : countMap.values()) {
////           if (count - min > 1) {
////               count
////           }
////       }
//        return ans;
//    }

//    public int minGroupsForValidAssignment(int[] nums) {
//        int n = nums.length;
//        int[] arr = new int[1000_000_000];
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            arr[nums[i]]++;
//        }
//
//
//        for(int i : map.values()) {
//
//        }
//
//
//        return ans;
//    }

//    @Test
//    public void test() {
//        Assert.assertEquals(4, minGroupsForValidAssignment1(new int[]{10,10,10,3,11,11}));
//        Assert.assertEquals(2, minGroupsForValidAssignment1(new int[]{3,2,3,2,3}));
//
//
//    }
}
