package com.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/31 23:56
 */
public class IsPalindrome_9 {

    /**
     * 解法一：转成字符串，然后用两个指针，一个从头，一个从尾，都往中间移动，直到
     * 两个下标s和e相等，或者s > e，就结束
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String str = x + "";
        int s = 0, e = str.length() -1 ;
        while(s <= e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    /**
     * 解法二：
     * 按照题意不能转成字符串，就用数字来解决，初步想法是把数字反过来，如果和原数字一样，
     * 就是回文数。但是存在特殊情况，Integer的最大值返回来回溢出，所以我们只比较数字的一半
     * 就不会溢出。
     * 左边的数字是x不断的 / 10，右边的数字是x 不断的加上 * 10的数字，当左边的数字大于x，
     * 就结束比较。
     * 又因为数字可能是偶数或者奇数，所以return x == r / 10 || r == x 任意一个相等都可以
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || ((x % 10) == 0 && x != 0)) {
            return false;
        }

       int r = 0;
        while (x > r) {
            r = r * 10 + x % 10;
            x =  x / 10;
        }
        return x == r / 10 || r == x;
    }

    @Test

        public void test1() {
        Assert.assertEquals(true, isPalindrome2(8));
        Assert.assertEquals(true, isPalindrome2(0));
        Assert.assertEquals(false, isPalindrome2(10));
        Assert.assertEquals(true, isPalindrome2(121));
        Assert.assertEquals(true, isPalindrome2(12321));
        Assert.assertEquals(false, isPalindrome2(-12321));
        }
}