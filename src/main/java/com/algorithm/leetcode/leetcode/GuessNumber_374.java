package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/9/19 8:09
 */
public class GuessNumber_374 {

    private int curNum;

    public int guessNumber(int n) {
        int l = 0, r = n, mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int flag = guess(mid);
            if (flag == 0) {
                return mid;
            } else if (flag == 1) {
                // 说明猜的数字小了  要调大
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }
        return mid;

    }


    public int guess(int num) {
        if (num == curNum) {
            return 0;
        } else if (curNum < num) {
            return -1;
        } else {
            return 1;
        }
    }

    @Test
    public void test1() {
        curNum = 6;
        Assert.assertEquals(6, guessNumber(10));


        curNum = 1;
        Assert.assertEquals(1, guessNumber(1));


        Assert.assertEquals(1, guessNumber(2));

        curNum = 2;
        Assert.assertEquals(2, guessNumber(2));

        curNum= Integer.MAX_VALUE;
        Assert.assertEquals(curNum, guessNumber(curNum));

    }
}