package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

public class LCP_116_2 {

    public int minChanges(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {

            if (chars[i] == '1') {

                while (i % 2 == 0 && chars[i + 1] == '0') {
                    i++;
                    count++;
                }
            } else {
                while (i % 2 == 0 && chars[i + 1] == '1') {
                    i++;
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, minChanges("1001"));
//        Assert.
    }
}
