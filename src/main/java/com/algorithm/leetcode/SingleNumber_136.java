package com.algorithm.leetcode;

public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            t ^= nums[i];
        }
        return t;
    }
}
