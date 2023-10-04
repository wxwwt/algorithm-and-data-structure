package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/8/2 22:42
 */
public class RemoveDuplicatesII_80 {

//    public int removeDuplicates(int[] nums) {
//        return process(nums, 2);
//    }

    public int removeDuplicates(int[] nums) {
        return call(nums, 2);
    }

//    int process(int[] nums, int k) {
//        int u = 0;
//        for (int x : nums) {
//            if (u < k || nums[u - k] != x) {
//                nums[u++] = x;
//            }
//        }
//        return u;
//    }


    public int call(int[] nums, int n) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < n || nums[i] != nums[s - n]) {
                nums[s++] = nums[i];
            }
        }
        return s;
    }

    @Test
    public void test1() {
//        int[] arr = new int[]{0,0,1,1,1,1,2,3,3};
//        Assert.assertArrayEquals(new int[]{0,0,1,1,2,3,3}, Arrays.copyOfRange(arr, 0, removeDuplicates(arr)));

        int[] arr2 = new int[]{1, 1, 1, 2, 2, 3};
        Assert.assertArrayEquals(new int[]{1, 1, 2, 2, 3}, Arrays.copyOfRange(arr2, 0, removeDuplicates(arr2)));
    }
}