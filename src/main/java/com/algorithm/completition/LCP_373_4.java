package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LCP_373_4 {

    public int beautifulSubstrings(String s, int k) {
        int kSquareRoot = (int) sqrt(k * 4);
        Map<Integer, Integer> count = new HashMap<>();
        count.put((kSquareRoot - 1), 0); // k-1 和 -1 同余
        int ans = 0, preSum = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            preSum += c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : -1;
            int p = (i % kSquareRoot) * 10 + preSum;
            ans += count.getOrDefault(p, 0);
            count.put(p, count.getOrDefault(p, 0) + 1);
        }
        return ans;
    }

    public int sqrt(int n) {
        int res = 1;
        int i = 2;
        while (i * i <= n) {
            int i2 = i * i;
            while (n % i2 == 0) {
                res *= i;
                n /= i2;
            }
            if (n % i == 0) {
                res *= i;
                n /= i;
            }
            i++;
        }
        if (n > 1) {
            res *= n;
        }
        return res;
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, beautifulSubstrings("baeyh", 2));
        Assert.assertEquals(0, beautifulSubstrings("a", 1));
        Assert.assertEquals(3, beautifulSubstrings("abba", 1));

        Assert.assertEquals(1, beautifulSubstrings("uzuxpzou",3));

    }
}
