package com.algorithm.leetcode;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author scott
 * @date 2022/9/17 23:20
 */
public class BinarySearch_704 {


    public int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1, mid = r, pos = -1;
        while (l <= r) {
            mid = r + l >> 1;
            if (nums[mid] == target) {
                 pos = mid;
                 break;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return pos;

    }

    @Test
    public void test1() {
        Assertions.assertEquals(4, search(new int[]{-1,0,3,5,9,12}, 9));
    }
}