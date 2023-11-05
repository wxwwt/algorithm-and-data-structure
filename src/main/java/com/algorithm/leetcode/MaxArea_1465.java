package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxArea_1465 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = 0;
        int maxW = 0;
        int pre = 0;
        for (int i : horizontalCuts) {
            int temp = i - pre;
            pre = i;
            if (temp > maxH) {
                maxH = temp;
            }
        }
        maxH = Math.max(maxH, h - pre);

        pre = 0;
        for (int i : verticalCuts) {
            int temp = i - pre;
            pre = i;
            if (temp > maxW) {
                maxW = temp;
            }
        }
        maxW = Math.max(maxW, w - pre);
        return (int) (maxH * maxW % 1000_000_007L);
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, maxArea(5,4, new int[]{1,2,4},new int[]{1,3}));
        Assert.assertEquals(6, maxArea(5,4, new int[]{3,1},new int[]{1}));

    }
}
