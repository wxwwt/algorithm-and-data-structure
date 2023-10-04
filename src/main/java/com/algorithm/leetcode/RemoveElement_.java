package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/30 22:20
 */
public class RemoveElement_ {

    private void exchange(int[] nums, int s, int j) {
        int temp = nums[s];
        nums[s] = nums[j];
        nums[j] = temp;
    }

    public int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length ; j++) {
                    if (nums[j] != val) {
                        exchange(nums, i, j);
                        break;
                    }
                }
            }
        }

        for (int i = 0 ; i < nums.length; i++) {
            if (val == nums[i]) {
                return i;
            }
        }
        return  nums.length;
    }

    @Test
    public void test1() {
        Assert.assertEquals(5, removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        Assert.assertEquals(2, removeElement(new int[]{3,2,2,3}, 3));
    }

}