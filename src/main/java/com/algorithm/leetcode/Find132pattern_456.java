package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Find132pattern_456 {

    public boolean find132pattern(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (k > nums[i]) {
                return true;
            }
            while (!deque.isEmpty() && deque.peek() < nums[i]) {
                k = deque.pop();
            }
            deque.push(nums[i]);
        }

        return false;
    }

    @Test
    public void test1() {
        Assert.assertEquals(false, find132pattern(new int[]{1,2,3,4}));
        Assert.assertEquals(true, find132pattern(new int[]{-1,3,2,0}));
    }
}
