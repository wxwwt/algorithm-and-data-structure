package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2021/10/12 7:27
 */
public class TwoSumII_167 {

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers[0] > target) {
            return null;
        }

        int startIndex = 0;
        int endIndex = numbers.length - 1;
        while (startIndex != endIndex) {
            // 首尾的值比target大就挪动尾指针 小就挪动首指针
            if (numbers[startIndex] + numbers[endIndex] > target) {
                --endIndex;
            } else if (numbers[startIndex] + numbers[endIndex] < target) {
                ++startIndex;
            } else {
                return new int[]{startIndex + 1, endIndex + 1};
            }
        }
        return null;


 
    }


    @Test
    public void test1() {
        int[] nums1 = new int[]{2, 7, 11, 15};
        int target1 = 9;
        Assert.assertArrayEquals(twoSum(nums1, target1), new int[]{1, 2});

        int[] nums2 = new int[]{2, 3, 4};
        int target2 = 6;
        Assert.assertArrayEquals(twoSum(nums2, target2), new int[]{1, 3});

        int[] nums3 = new int[]{3, 3};
        int target3 = 6;
        Assert.assertArrayEquals(twoSum(nums3, target3), new int[]{1, 2});

        int[] nums4 = new int[]{-1, 0};
        int target4 = -1;
        Assert.assertArrayEquals(twoSum(nums4, target4), new int[]{1, 2});
    }
}