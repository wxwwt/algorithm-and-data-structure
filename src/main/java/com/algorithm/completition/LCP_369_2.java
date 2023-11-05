package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

public class LCP_369_2 {

    public long minSum(int[] nums1, int[] nums2) {

        long countZ1 = 0, countZ2 = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                countZ1++;
            } else {
                sum1 += nums1[i];
            }

        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                countZ2++;
            } else {
                sum2 += nums2[i];
            }
        }


        if (sum1 + countZ1 < sum2 + countZ2) {
            while (sum1 + countZ1 < sum2 + countZ2) {
                if (countZ1 > 0) {
                    countZ1 = sum2 + countZ2 - sum1;
                } else {
                    break;
                }

            }
        } else if (sum1 + countZ1 == sum2 + countZ2) {
            return sum1 + countZ1;
        } else {
            while (sum1 + countZ1 > sum2 + countZ2) {
                if (countZ2 > 0) {
                    countZ2 = sum1 + countZ1 - sum2;
                } else {
                    break;
                }
            }
        }

        return sum1 + countZ1 == sum2 + countZ2 ? sum1 + countZ1 : -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(12, minSum(new int[]{3,2,0,1,0}, new int[]{6,5,0}));
        Assert.assertEquals(-1, minSum(new int[]{2,0,2,0}, new int[]{1,4}));
    }
}
