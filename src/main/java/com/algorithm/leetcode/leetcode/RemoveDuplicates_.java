package com.algorithm.leetcode.leetcode;

/**
 * @author scott
 * @date 2023/7/31 23:46
 */
public class RemoveDuplicates_ {

    public int removeDuplicates(int[] nums) {
        int s = 0 ;
        for (int i =1; i< nums.length;i++) {
            if (nums[s] != nums[i] ) {
                nums[s + 2] = nums[i];
                s +=2;
            }
        }
        return s + 1;
    }
}