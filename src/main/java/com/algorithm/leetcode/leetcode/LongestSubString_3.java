package com.algorithm.leetcode.leetcode;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author scott
 * @date 2019/3/7 19:48
 */

public class LongestSubString_3 {

    public static int longestSub(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left) {
                left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i + 1 - left);
        }
        return max;
    }

    public int getLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int length = 0;
        Map<String, Integer> hashMap = new HashMap<>();
        char[] charArr = str.toCharArray();
        while (end <= charArr.length - 1) {
            // 如果有重复 下标重新开始计算
            Integer temp = hashMap.get(String.valueOf(charArr[end]));
            if (temp != null && temp >= start) {
                length = Math.max(end - start, length);
                Integer newIndex = hashMap.get(String.valueOf(charArr[end]));
                start = newIndex + 1;
            }
            hashMap.put(String.valueOf(charArr[end]), end);
            end++;
        }
        return Math.max(length, end - start);
    }


    @org.junit.Test
    public void test1() {
        Assert.assertEquals(5, getLength("pwwkerp"));
        Assert.assertEquals(3, getLength("abcabcbb"));

        Assert.assertEquals(3, getLength("dvdf"));

        Assert.assertEquals(3, getLength("pwwkew"));

    }

    public static void main(String[] args) {
        System.out.println(longestSub("abba"));
        System.out.println(longestSub("dvdf"));
        System.out.println(longestSub("pwwekw"));
        System.out.println(longestSub("abcabcbb"));
        System.out.println(longestSub("bbbbb"));
    }
}
