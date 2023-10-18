package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class NextGreaterElements_503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            // 因为要找的是右边比大的元素 所以和单调栈比较的元素是更大的元素 所以单调栈是从栈顶到栈底是递增的
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                int index = stack.pop();
                ans[index] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ans;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int []{-1}, nextGreaterElements(new int[]{1}));
        Assert.assertArrayEquals(new int[]{-1, 5, 5, 5, 5}, nextGreaterElements(new int[]{5, 4, 3, 2, 1}));
        Assert.assertArrayEquals(new int []{2,-1,2}, nextGreaterElements(new int[]{1,2,1}));
    }
}
