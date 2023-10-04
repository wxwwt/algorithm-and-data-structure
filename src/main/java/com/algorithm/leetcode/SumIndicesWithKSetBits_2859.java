package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SumIndicesWithKSetBits_2859 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size();
        int count = 0;
            for (int i = 0 ; i < n; i++) {
                Integer.bitCount(i);
               String s = Integer.toBinaryString(i);
               char[] chars = s.toCharArray();
               int tk = 0;
               for (int j = 0; j < chars.length; j++) {
                   if (chars[j] == '1') {
                       tk++;
                   }
               }

                if (tk == k) {
                    count += nums.get(i);
                }
            }
        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(13, sumIndicesWithKSetBits(List.of(5,10,1,5,2), 1));
        Assert.assertEquals(1, sumIndicesWithKSetBits(List.of(4,3,2,1), 2));

    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(1));
        System.out.println(Integer.bitCount(2));
    }

}
