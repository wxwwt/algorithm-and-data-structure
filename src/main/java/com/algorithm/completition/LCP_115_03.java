package com.algorithm.completition;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LCP_115_03 {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {


            while (!stack.isEmpty() && groups[stack.peek()] == groups[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.push(i);

            } else if(deal(words[stack.peek()], words[i])) {
                stack.push(i);
            } else {


                    while(!stack.isEmpty()) {
                        ans.add( words[stack.removeLast()]);
                    }


                max = stack.size();

                stack.clear();
                stack.push(i);
            }




        }

        if (stack.size() > max) {
            ans.clear();
            while (!stack.isEmpty()) {
                ans.add(words[stack.removeLast()]);
            }
        }

        return ans;
    }

    public boolean deal(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int n = a.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count > 1) {
                return false;
            }

            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    @Test
    public void test1() {

        Assert.assertEquals(Lists.newArrayList(), getWordsInLongestSubsequence(3,new String[]{"bdb","aaa","ada"},new int[]{2,1,3}));

//        Assert.assertEquals(Lists.newArrayList("acace"), getWordsInLongestSubsequence(2,new String[]{"adbe","acace"},new int[]{2,2}));

//        Assert.assertEquals(Lists.newArrayList(), getWordsInLongestSubsequence(1,new String[]{"a"},new int[]{1}));

//        Assert.assertEquals(Lists.newArrayList(), getWordsInLongestSubsequence(3,new String[]{"bab","dab","cab"},new int[]{1,2,2}));
    }
}
