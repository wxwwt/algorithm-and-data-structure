package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/7/29 22:35
 */
public class MaximumSum_1186 {

    public int maximumSum(int[] arr) {
        int s = 0;
        int nIndex = -1 ;
        int max = arr[0];
        int temp = 0;
        int hasPo = 0;
        for (int i = 0; i < arr.length;i++) {

            if (arr[i] < 0) {
                // 没有负数的情况就一直往后加
                if (nIndex < 0) {
                    nIndex = i;
                    temp += arr[i];
                } else {
                    // 遇到第二个负数 就从第一个负数往后加一位重新开始算
                    s = nIndex + 1;
                    nIndex = -1;
                    i = s;
                    temp = arr[s];
                }
            } else {
                hasPo = 1;
                // 如果是正数直接加上去
                temp += arr[i];
            }
        max = Math.max(arr[i], Math.max(max, nIndex < 0 ? temp : temp - arr[nIndex]));
        }

        if (hasPo == 0) {
            return Arrays.stream(arr).max().getAsInt();
        }
        return max;
    }

    @Test
    public void test() {
        Assert.assertEquals(14, maximumSum(new int[]{8,-1,6,-7,-4,5,-4,7,-6}));
        Assert.assertEquals(4, maximumSum(new int[]{1,-2,0,3}));
        Assert.assertEquals(3, maximumSum(new int[]{1,-2,-2,3}));
        Assert.assertEquals(-1, maximumSum(new int[]{-1,-1,-1,-1}));
    }
}