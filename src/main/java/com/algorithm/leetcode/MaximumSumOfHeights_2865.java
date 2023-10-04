package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MaximumSumOfHeights_2865 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long n = maxHeights.size();
        long res = 0;
        for (int i = 0; i < n; i++) {
            // 选i为峰值
            long count = maxHeights.get(i);
            long l = maxHeights.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (maxHeights.get(j) > l) {
                    count +=l;
                } else {
                    count +=maxHeights.get(j);
                    l = maxHeights.get(j);
                }
            }

            long r = maxHeights.get(i);
            for (int z = i + 1; z < n; z++) {

                if (maxHeights.get(z) > r) {
                    count +=r;
                } else {
                    count +=maxHeights.get(z);
                    r = maxHeights.get(z);
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }


    @Test
    public void test1() {
        Assert.assertEquals(3000000000L, maximumSumOfHeights(List.of(1000000000,1000000000,1000000000)));
        Assert.assertEquals(13, maximumSumOfHeights(List.of(5,3,4,1,1)));
        Assert.assertEquals(22, maximumSumOfHeights(List.of(6,5,3,9,2,7)));

        Assert.assertEquals(18, maximumSumOfHeights(List.of(3,2,5,5,2,3)));

        Assert.assertEquals(20, maximumSumOfHeights(List.of(3,1,3,2,6,1,4,4,6)));

    }
}
