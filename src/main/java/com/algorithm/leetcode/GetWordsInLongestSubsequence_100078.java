package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GetWordsInLongestSubsequence_100078 {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && groups[stack.peek()] == groups[i]) {
                stack.pop();
            }
            stack.push(i);
        }

        List<String> ans = new ArrayList<>();
        while(!stack.isEmpty()) {
           ans.add( words[stack.removeLast()]);
        }
        return ans;
    }

    @Test
    public void test1() {

//        Assert.assertEquals(Lists.newArrayList(), getWordsInLongestSubsequence(4,new String[]{"a","b","c","d"},new int[]{1,0,1,1}));

        Assert.assertEquals(Lists.newArrayList(), getWordsInLongestSubsequence(3,new String[]{"e","a","b"},new int[]{0,0,1}));
    }
}
