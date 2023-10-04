package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumOddBinaryNumber_2864 {

    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int zero = 0;
        int one = 0;
        for (char ch : chars) {
            if (ch == '0') {
                zero++;
            } else {
                one++;
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        while (zero > 0 || one > 0) {
            if (deque.size() == 0) {
                deque.offerLast(1);
                one--;
            } else {
                while (zero > 0) {
                    deque.addFirst(0);
                    zero--;
                }

                while (one > 0) {
                    deque.addFirst(1);
                    one--;
                }

            }
        }

        StringBuilder b = new StringBuilder();
        for (int i : deque) {
            b.append(i);
        }
        return b.toString();
    }

    @Test
    public void test1() {
        Assert.assertEquals("001", maximumOddBinaryNumber("010"));
    }
}
