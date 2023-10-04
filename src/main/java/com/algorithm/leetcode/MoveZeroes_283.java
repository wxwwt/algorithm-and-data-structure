package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/26 22:06
 */
public class MoveZeroes_283 {

    public int[] moveZeroes(int[] nums) {
        int s = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                s = i;
                for (int j = s + 1; j < nums.length; j++) {
                    if (nums[j] != 0 && nums[s] == 0) {
                        int temp  = nums[s];
                        nums[s] = nums[j];
                        nums[j] = temp;
                        s++;
                    }
                }
                break;
            }
        }



        // 为了测试加上了返回值 其实原来的函数是返回值void
        return nums;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{ 1,3,12,0,0}, moveZeroes(new int[]{0,1,0,3,12}));
        Assert.assertArrayEquals(new int[]{ 1}, moveZeroes(new int[]{1}));

//        Assert.assertArrayEquals(new int[]{ 0}, moveZeroes(new int[]{0}));
    }
}