package com.algorithm.leetcode;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MakeThreeStringsEqual_2937 {

    public int findMinimumOperations(String s1, String s2, String s3) {
        int count = 0;
        int min = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        for (int i = 0 ;i < min; i++) {
            if (s1.charAt(i) != s2.charAt(i) || s2.charAt(i) != s3.charAt(i)) {
                break;
            }
            count++;
        }
        return count == 0 ? -1 : s1.length() + s2.length() + s3.length() - count * 3;
    }

    @Test
    public void test1() {
        Assertions.assertEquals(2, findMinimumOperations("abc", "abc", "ab"));
    }
}
