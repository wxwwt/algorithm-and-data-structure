package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/9/3 10:29
 */
public class CountSymmetricIntegers_2843 {

    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String t = i + "";
            if ((i + "").length() % 2 == 0) {
                char[] arr = t.toCharArray();
                int s = 0;
                int e = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (j < t.length() / 2) {
                        s += Integer.valueOf(arr[j] + "")  ;
                    } else {
                        e += Integer.valueOf(arr[j] + "") ;
                    }

                }
                if (s == e) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, countSymmetricIntegers(1200, 1230));
        Assert.assertEquals(9, countSymmetricIntegers(1, 100));
        Assert.assertEquals(0, countSymmetricIntegers(1, 1));
    }
}