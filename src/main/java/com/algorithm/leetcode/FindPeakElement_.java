package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/8/5 16:18
 */
public class FindPeakElement_ {

    public int findPeakElement(int[] nums) {

        int l = 0, r = nums.length - 1,  mid = (r - l) / 2 + l;
        while (l < r) {
            mid = (r - l) / 2 + l;
            // 如果符合条件直接返回
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                // 因为这道题目说了 nums[i] != nums[i+1] 所以不用判断相等的情况了
                l = mid + 1;
            }
        }
        return l;
    }

    @Test
    public void test1(){
        Assert.assertEquals(2, findPeakElement(new int[]{1,2,3,1}));
        Assert.assertEquals(5, findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}