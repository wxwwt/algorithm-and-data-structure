package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindThePeaks_100144 {


    public List<Integer> findPeaks(int[] mountain) {
        int n = mountain.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (mountain[i - 1]  < mountain[i] && mountain[i] > mountain[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }

    @Test
    public void test1() {
        Assert.assertEquals(Lists.newArrayList(1,3), findPeaks(new int[]{1,4,3,8,5}));
    }
}
