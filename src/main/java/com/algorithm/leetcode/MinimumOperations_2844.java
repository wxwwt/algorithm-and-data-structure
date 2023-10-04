package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/9/3 10:29
 */
public class MinimumOperations_2844 {


    /**
     * 方法一：从结尾去匹配是否是 25 50 75 00
     * 在特殊处理下0的情况
     * @param num
     * @return
     */
    public int minimumOperations1(String num) {
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int j = num.length() - 1; j >= 0; j--) {
            char c = num.charAt(j);
            count = num.length() - 1 - j;
            if (c == '0') {
                // 拿到以 0 结尾是 0 5
                for (int i = j - 1; i >= 0; i--) {
                    if (num.charAt(i) == '0' || num.charAt(i) == '5') {

                        break;

                    } else {
                        count++;
                    }

                }
                min = Math.min(min, count);
            } else if (c == '5') {
                boolean match = false;
                for (int i = j - 1; i >= 0; i--) {
                    if (num.charAt(i) == '2' || num.charAt(i) == '7') {
                        match = true;
                        break;
                    } else {
                        count++;
                    }
                }
                min = Math.min(min, match ? count :++count);
            } else {
                count++;
            }
        }

        return Math.min(count, min);
    }

    public int minimumOperations(String num) {
        int ans = num.length();
        if (num.contains("0")) {
            ans--;
        }

      ans = call(num, "25", ans);
      ans = call(num, "50", ans);
      ans = call(num, "75", ans);
      ans = call(num, "00", ans);
       return ans;
    }

    private int call(String num, String temp, int ans) {
        char[] chars = temp.toCharArray();
        for (int i = num.length() - 1; i >= 0 ; i--) {
            if (num.charAt(i) == chars[1]) {

                while (i > 0) {
                    i--;
                    if (num.charAt(i) == chars[0]) {
                        return Math.min(num.length() - i - 2, ans);
                    }
                }
            }
        }
        return ans;
    }



    @Test
    public void test1() {
        Assert.assertEquals(3, minimumOperations("151"));
        Assert.assertEquals(0, minimumOperations("100"));
        Assert.assertEquals(2, minimumOperations("51"));
        Assert.assertEquals(2, minimumOperations("15"));
        Assert.assertEquals(1, minimumOperations("5"));

        Assert.assertEquals(3, minimumOperations("2908305"));

        Assert.assertEquals(2, minimumOperations("2245047"));

        Assert.assertEquals(1, minimumOperations("10"));


        Assert.assertEquals(1, minimumOperations("1"));

        Assert.assertEquals(0, minimumOperations("250"));
//        UnionFind uf = new FindCircleNum_547.UnionFind(10);
    }
}