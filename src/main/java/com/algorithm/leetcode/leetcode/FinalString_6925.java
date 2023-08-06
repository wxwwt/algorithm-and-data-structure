package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/8/6 10:34
 */
public class FinalString_6925 {

    public String finalString(String s) {
        if (s.length() == 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ('i' == c) {
                builder.reverse();
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }


    @Test
    public void test1() {
        Assert.assertEquals("rtsng", finalString("string"));
        Assert.assertEquals("ponter", finalString("poiinter"));
        Assert.assertEquals("s", finalString("si"));
        Assert.assertEquals("s", finalString("s"));
    }
}