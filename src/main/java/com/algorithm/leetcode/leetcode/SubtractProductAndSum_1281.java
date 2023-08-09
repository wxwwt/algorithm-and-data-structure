package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/8/9 22:52
 */
public class SubtractProductAndSum_1281 {

    public int subtractProductAndSum(int n) {
        int[] arr = new int[5];
        int index = 0;
        int temp = 0;
            while(n > 0) {
                temp = n % 10;
                n = n / 10;
                arr[index++] = temp;
            }

            int sum = 0;
            int multi = 1;
            for ( int i= 0; i < index; i++) {
             sum += arr[i];
             multi *= arr[i];

            }
            return multi - sum;
    }

    @Test
    public void test1() {
        Assert.assertEquals(59004, subtractProductAndSum(99999));
        Assert.assertEquals(0, subtractProductAndSum(3));
        Assert.assertEquals(15, subtractProductAndSum(234));
        Assert.assertEquals(21, subtractProductAndSum(4421));

    }

}