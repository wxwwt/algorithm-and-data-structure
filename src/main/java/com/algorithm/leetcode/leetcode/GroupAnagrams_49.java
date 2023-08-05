package com.algorithm.leetcode.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2023/7/30 21:33
 */
public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String newS = new String(arr);
            List<String> subList = map.getOrDefault(newS, new ArrayList<>());
            subList.add(strs[i]);
            map.put(newS, subList);
        }
            return new ArrayList<>(map.values());
        }

        @Test
        public void test1 () {
            System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
            System.out.println(groupAnagrams(new String[]{""}));
            System.out.println(groupAnagrams(new String[]{"a"}));

        }
    }