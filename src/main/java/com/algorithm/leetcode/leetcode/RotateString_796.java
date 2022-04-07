package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author scott
 * @date 2022/4/7 22:24
 */
public class RotateString_796 {

    /**
     * s的char数组每次转移一个字符，从最左边转移到最右边，
     * 然后和goal的字符串比较一下
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String head = s.substring(0, 1);
            String tail = s.substring(1);
            s = tail + head;
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 看了官方的题解后，原来一行就行。。。
     * goal如果是s旋转后的字符串，s+s一定包含了goal
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    @Test
    public void test1() {
        Assert.assertTrue(rotateString("abcde", "cdeab"));
        Assert.assertFalse(rotateString("abcde", "abced"));

        Assert.assertTrue(rotateString2("abcde", "cdeab"));
        Assert.assertFalse(rotateString2("abcde", "abced"));
    }
}