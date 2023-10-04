package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author scott
 * @date 2023/7/19 8:34
 */
public class DailyTemperatures_739 {


    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                    // 当前元素大于栈顶元素
                if (temperatures[stack.peek()] < temperatures[i]) {
                    while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                        int index = stack.pop();
                        arr[index] = i - index;
                    }
                    stack.push(i);
                } else {
                    // 当前元素小于 或者等于栈顶
                    stack.push(i);
                }
            }
        }
        return arr;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}) );
    }
}