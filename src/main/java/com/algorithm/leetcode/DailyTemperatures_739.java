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
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 当前元素大于栈顶元素
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                answer[index] = i - index;

            }
            // 栈是空的 或者 当前元素小于或者等于栈顶 就放入栈中
            stack.push(i);
        }
        return answer;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}