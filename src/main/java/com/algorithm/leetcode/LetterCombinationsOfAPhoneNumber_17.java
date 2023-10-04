package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scott
 * @date 2023/6/23 22:30
 */
public class LetterCombinationsOfAPhoneNumber_17 {

    String[] arr = new String[]{
            // 0
            "",
            // 1
            "",
            // 2
            "abc",
            // 3
            "def",
            // 4
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };


    StringBuilder path = new StringBuilder();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backTracking(digits, 0);
        return result;
    }

    public void backTracking(String search, int index) {
        if (path.length() == search.length()) {
            result.add(path.toString());
            return;
        }

        int temp = search.charAt(index) - '0';
        for (int i = 0; i < arr[temp].length(); i++) {
            path.append(arr[temp].charAt(i));
            backTracking(search, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    @Test
    public void test1() {
        System.out.println(letterCombinations("23"));
    }
}