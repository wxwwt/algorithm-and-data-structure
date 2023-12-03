package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

public class LCP_372_2 {

    public long minimumSteps(String s) {
        char[] chars = s.toCharArray();
        long ans = 0L;
        int n = chars.length;
        int cur = Integer.MAX_VALUE;
        int i = n - 1;
        while (cur > 0 && i >=0) {
            if (chars[i] == '0') {
                if (cur == Integer.MAX_VALUE) {
                    cur = i - 1;
                    if (cur < 0) {
                        continue;
                    }
                }

                if (chars[cur] == '0') {
                    while (cur > 0 && chars[cur] == '0') {
                        cur--;
                    }

                }

                if (chars[cur] == '1') {
                    ans += i - cur;
                    chars[cur] = '0';
                }


            }
            i--;
        }
        return ans;
    }


    @Test
    public void test1() {
        Assert.assertEquals(7, minimumSteps("01010001"));
        Assert.assertEquals(6, minimumSteps("11000111"));
        Assert.assertEquals(1, minimumSteps("101"));
        Assert.assertEquals(2, minimumSteps("100"));
        Assert.assertEquals(0, minimumSteps("0111"));

    }
}
