package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

public class LCP_367_3 {

    public String shortestBeautifulSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;
        int count = 0;
        int length = 0;
        String ans = "";
        for (int i = 0; i < n; i++) {
            if (chars[i] == '1') {
                count++;
                if (count > k) {
                    while (count > k) {
                        if (chars[start] == '1') {
                            count--;

                        }
                        start++;
                    }


                }
            }

            if (count == k) {

                if (chars[start] == '0') {
                    while (chars[start] == '0') {
                        start++;
                    }
                }


                int t = i - start + 1;
                if (ans.length() > 0) {
                    // 返回更小的那个
                    if (t < length) {
                        String value = s.substring(start, i + 1 <= n ? i + 1 : i);
                        ans = value;
                        length = t;
                    } else if (t == length) {
                        String value = s.substring(start, i + 1 <= n ? i + 1 : i);
                        ans = ans.compareTo(value) > 0 ? value : ans;
                    }
                } else {
                    length = i - start + 1;
                    ans = s.substring(start, i + 1 <= n ? i + 1 : i);
                }

            }
        }

        return ans;
    }

    @Test
    public void test() {

        Assert.assertEquals("1", shortestBeautifulSubstring("001", 1));

        Assert.assertEquals("11101111001", shortestBeautifulSubstring("1100001110111100100", 8));
        Assert.assertEquals("11001", shortestBeautifulSubstring("100011001", 3));
        Assert.assertEquals("11", shortestBeautifulSubstring("1011", 2));
        Assert.assertEquals("", shortestBeautifulSubstring("000", 3));
    }
}
