//package com.algorithm.leetcode.completition;
//
//import java.util.Collections;
//import java.util.List;
//
///**
// * @author scott
// * @date 2023/8/27 11:15
// */
//public class LCP360_03 {
//
//    public int minOperations(List<Integer> nums, int target) {
//        int sum = 0;
//        int oneS = 0;
//        int index = -1;
//        int minV = 0;
//        Collections.sort(nums);
//        for (int i = 0; i < nums.size(); i++) {
//                sum += nums.get(i);
//                if (i == 1) {
//                    oneS +=1;
//                }
//
//                if (index == -1 && nums.get(i) > target) {
//                    index = i;
//                }
//
//                if (nums.get(i) < target) {
//                    minV += nums.get(i);
//                }
//
//            }
//
//        if (sum < target ) {
//            return -1;
//        }
//
//      if (target - oneS < 0) {
//          return -1;
//      }
//
//
//        if (target -oneS > 0 && target - oneS % 2 != 0) {
//            return -1;
//        }
//
//       int rest = target -
//        for (int i = 0; i < nums.size(); i++) {
//
//        }
//    }
//}