package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shenchuang
 * @date 2022/4/11 11:31 AM
 */
public class CountNumbersWithUniqueDigits_357 {

    /**
     * 这个题目一开始没有看明白，以为说n = 2，是只算两位数中，个位和十位不重复的数字有多少。
     * 后来发现答案是91是包含了个位数的，就是1位数的10个数(0-9)和2位数去掉11，22这样的数字后剩下81个数字，
     * 加起来是91个。
     * 看下规律是什么：
     * n   result
     * 0   1
     * 1   10
     * 然后从2开始规律开始变化,2位数的结果等于1位数的结果，加上2位数中不重复的数值
     * 2   f(1) + 9*9
     * 3   f(2) + 9*9*8
     * 可以看出来可以用dp来解决，方程中后面这一部分其实是排列组合，拿三位数举例：
     * 三位数的百位可以是1-9中的任意一个数字，选择方式有9种
     * 十位可以是[0-9]中的一个数字，又因为百位已经用掉一个数字了，所以是在0-9中在去掉百位已经用掉的数字，有9中选法
     * 个位同理，[0-9]中去掉百位，十位用过的数字，所以有8种选法
     * 最后相乘就是9 * 9 * 8，公式如下。
     * f(n) = f(n-1) + 9 * (9的阶乘长度为n -1)
     * f(2) = f(1) + 9 * A19
     * f(3) = f(2) + 9 * A19 * A18
     *
     * 时间复杂度：O(n), 遍历一次
     * 空间复杂度：O(n), dp[]占用的空间
     * @param n
     * @return
     */
    int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 1;
        dp[1] = 10;
        int factor = 9;
        for (int i = 2; i <= n; i++) {
            // 这里的 11 -i 是从(10- (i-1))化简而来的
            factor *= (11 - i);
            dp[i] = dp[i - 1] + factor;
        }
        return dp[n];
    }

    @Test
    public void test1() {
        Assert.assertEquals(739, countNumbersWithUniqueDigits(3));
        Assert.assertEquals(1, countNumbersWithUniqueDigits(0));
        Assert.assertEquals(10, countNumbersWithUniqueDigits(1));
        Assert.assertEquals(91, countNumbersWithUniqueDigits(2));
    }
}
