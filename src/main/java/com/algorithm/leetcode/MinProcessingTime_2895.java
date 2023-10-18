package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class MinProcessingTime_2895 {


    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int n = processorTime.size();
        int m = tasks.size();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int index = m - 1 - i * 4;
           int temp = Math.max(Math.max(Math.max(tasks.get(index), tasks.get(index -1)), tasks.get(index -2)), tasks.get(index - 3));
            max = Math.max(max, temp + processorTime.get(i));
        }
        return  max;
    }

    @Test
    public void test1() {
        Assert.assertEquals(10,minProcessingTime(Lists.newArrayList(2), Lists.newArrayList(8,8,8,8)));
        Assert.assertEquals(16, minProcessingTime(Lists.newArrayList(8, 10), Lists.newArrayList(2,2,3,1,8,7,4,5)));
        Assert.assertEquals(23, minProcessingTime(Lists.newArrayList(10,20), Lists.newArrayList(2,3,1,2,5,8,4,3)));
    }
}
