package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author scott
 * @date 2023/6/10 17:39
 */
public class Combinations_77 {

    private Stack<Integer> stack = new Stack<>();

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 使用回溯法
        // 先确定参数和返回值（回溯返回值一般是void）
        // 在确定终止条件
        // 最后确定单层循环
        backTracking(n, k, 1);
        return result;
    }

    void backTracking(int n, int k, int startIndex) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            stack.push(i);
            backTracking(n, k, i+1);
            stack.pop();
        }
    }

    @Test
    public void test1() {
//        Assertions.assertEquals(new ArrayList<>(new ArrayList<>(){{add(1);}}), combine(1, 1));
        Assertions.assertEquals(Lists.newArrayList(Lists.newArrayList(2, 4),
                Lists.newArrayList(3, 4),
                Lists.newArrayList(2, 3),
                Lists.newArrayList(1, 2),
                Lists.newArrayList(1, 3),
                Lists.newArrayList(1, 4)), combine(4, 2));

    }
}