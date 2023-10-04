package com.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class FindDuplicate_287 {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        return binSearch(nums, 0, nums.length - 1) ;
    }

    public int binSearch(int[] nums, int left, int right) {
        int l = left, r = right;
        int duplicate = -1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int t  = nums[mid];
            if (mid + 1 < nums.length && nums[mid +1] == nums[mid] ) {
               return nums[mid];
            } else if (0 < mid - 1  && nums[mid -1] == nums[mid]) {
                return nums[mid];
            } else {
                int s = binSearch(nums, left + 1, mid -1);
                return s != -1 ? s : binSearch(nums, mid + 1, right - 1);
            }
        }
        return -1;
    }


    @Test
    public void test1() {

    }
}
