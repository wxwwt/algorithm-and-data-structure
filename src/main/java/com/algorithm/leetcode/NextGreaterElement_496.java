package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        // 先nums2中每个元素的右边大于它的元素算出来 存到hash表中 （前提是nums2中没有重复的元素）
        int n2 = nums2.length;
        for (int i = n2 - 1; i >= 0; i--) {
            // 栈顶到栈底是递增的
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        // 在遍历nums1把下标到nums2中对应的大于它的元素找出来
        for (int i = 0 ; i < n; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{-1,3,-1}, nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}));
        Assert.assertArrayEquals(new int[]{-1}, nextGreaterElement(new int[]{1}, new int[]{1}));
    }
}
