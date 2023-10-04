package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/1/29 22:28
 */
public class CountAsterisks_2315 {

    public int countAsterisks(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        boolean outside = true;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*' && outside) {
                count++;
            }

            if (arr[i] == '|') {
                outside = !outside;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, countAsterisks(null));
        Assert.assertEquals(0, countAsterisks("fdsafdsaf"));
        Assert.assertEquals(2, countAsterisks("l|*e*et|c**o|*de|"));
        Assert.assertEquals(5, countAsterisks("        yo|uar|e**|b|e***au|tifu|l"));
    }
}