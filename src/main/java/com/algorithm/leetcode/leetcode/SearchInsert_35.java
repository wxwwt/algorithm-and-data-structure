package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/8/4 23:24
 */
public class SearchInsert_35 {




    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;


    }

    @Test
    public void test1() {
//        Assert.assertEquals(0, searchInsert(new int[]{3, 5}, 2));
//        Assert.assertEquals(2, searchInsert(new int[]{3, 5}, 6));
//        Assert.assertEquals(1, searchInsert(new int[]{1,3},2));
//        Assert.assertEquals(0, searchInsert(new int[]{1}, -2));
//        Assert.assertEquals(1, searchInsert(new int[]{1}, 8));
//        Assert.assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));
//        Assert.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
        Assert.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
//        Assert.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
    }
}