package com.algorithm.leetcode;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * @author scott
 * @date 2023/5/21 22:11
 */
public class LCP_33 {

    public int storeWater(int[] bucket, int[] vat) {
        int times = Integer.MAX_VALUE;
       int maxK = Arrays.stream(vat).max().getAsInt();
       if (maxK == 0) {
           return 0;
       }
       for (int k = 1; k <= maxK; k++) {
           int temp = 0;
            for (int i = 0; i < vat.length; i++) {
                        if (vat[i] / k > bucket[i]) {
                            temp += vat[i] / k - bucket[i];
                        }
            }
           times = Math.min(times, temp + k);
       }
       return times;
    }


    @Test
    public void test1() {
//        Assertions.assertEquals(storeWater(new int[]{1,3}, new int[]{6,8}), 4);
        Assertions.assertEquals(storeWater(new int[]{  9,0,1}, new int[]{0,2,2}), 3);

    }
}