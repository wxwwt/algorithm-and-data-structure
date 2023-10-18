package com.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinNumberOfFrogs_1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] chars = croakOfFrogs.toCharArray();
        int n = chars.length;
        int ans = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'c') {
                count++;
            }

            if (chars[i] == 'k') {
                count--;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
