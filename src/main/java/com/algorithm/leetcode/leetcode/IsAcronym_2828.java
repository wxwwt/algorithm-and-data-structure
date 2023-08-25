package com.algorithm.leetcode.leetcode;

import java.util.List;

/**
 * @author scott
 * @date 2023/8/20 10:18
 */
public class IsAcronym_2828 {

    public boolean isAcronym(List<String> words, String s) {
        int n = s.length();
        if (n != words.size()) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (words.get(i).charAt(0) != chars[i]) {
                return false;
            }
        }
        return true;
    }
}