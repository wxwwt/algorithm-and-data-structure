package com.algorithm.leetcode.leetcode.offer;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author scott
 * @date 2023/5/7 17:41
 */
public class ReverseLeftWords_50 {

    public String reverseLeftWords(String s, int n) {
//      String right =  s.substring(0, n);
      return s.substring(n) + s.substring(0, n);
    }

    @Test
    public void Test1() {
        Assertions.assertEquals("cdefgab", reverseLeftWords("abcdefg", 2));
    }
}