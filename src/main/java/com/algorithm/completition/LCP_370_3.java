//package com.algorithm.completition;
//
//import com.google.common.collect.Lists;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class LCP_370_3 {
//
//
//    public int findKOr(int[] nums, int k) {
//        int sum = 0;
//        int[] count = new int[31];
//        for (int i = 0; i < 31; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                count[i] += (nums[j] >> i) & 1;
//                if (count[i] >= k) {
//                    sum = sum | (1 << i);
//                }
//            }
//        }
//        return sum;
//    }
//
//
//
//    @Test
//    public void test() {
//        Assert.assertEquals(15, sumCounts(Lists.newArrayList(1,2,1)));
//    }
//}
