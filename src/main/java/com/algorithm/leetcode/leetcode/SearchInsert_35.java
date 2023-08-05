package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/8/4 23:24
 */
public class SearchInsert_35 {

    public int searchInsert(int[] nums, int target) {


        int l = 0, r = nums.length - 1, mid =   (l + r) / 2;
        if (target > nums[r]) {
            return r + 1;
        }

        if (target < nums[l]) {
            return l;
        }

        int res = mid;
        while (l < r) {
             mid = (l + r) / 2;
             res  = mid;
            if(nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
                res = mid + 1;
            } else {
                return res;
            }
        }
        return res ;
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, searchInsert(new int[]{1,3},2));
        Assert.assertEquals(0, searchInsert(new int[]{1}, -2));
        Assert.assertEquals(1, searchInsert(new int[]{1}, 8));
        Assert.assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));
        Assert.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
        Assert.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
        Assert.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
    }
}