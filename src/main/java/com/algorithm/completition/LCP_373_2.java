package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/30 10:08
 */
public class LCP_373_2 {

    public int beautifulSubstrings(String s, int k) {
        int ans = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int v = 0 , c = 0;
            for (int j = i; j < n; j++) {
                if (chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u') {
                    v++;
                } else {
                    c++;
                }

                if (v == c && (v * v) % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, beautifulSubstrings("baeyh", 2));
        Assert.assertEquals(0, beautifulSubstrings("a", 1));
        Assert.assertEquals(3, beautifulSubstrings("abba", 1));

        Assert.assertEquals(1, beautifulSubstrings("uzuxpzou",3));
//        Assert.assertEquals(4, minimumPossibleSum(2,3));
//        Assert.assertEquals(8, minimumPossibleSum(3,3));
//        Assert.assertEquals(1, minimumPossibleSum(1,1));
//        Assert.assertEquals(12, minimumPossibleSum(4,4));
//
//        Assert.assertEquals(2948940321L, minimumPossibleSum(63623,82276));
//        System.out.println(Math.pow(10, 5));
    }
}