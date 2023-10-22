package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.function.IntToLongFunction;

public class MaxKelements_2530 {

    public long maxKelements(int[] nums, int k) {
        long ans = 0L;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b - a);
        for (int i: nums) {
            queue.offer(i);
        }

        while (k > 0) {
            int t = queue.poll();
            ans += t;
            t = (t + 2) / 3;
            queue.offer(t);
            k--;
        }
        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(3603535575L, maxKelements(new int[]{756902131,995414896,95906472,149914376,387433380,848985151}, 6));
        Assert.assertEquals(17, maxKelements(new int[]{1,10,3,3,3}, 3));
        Assert.assertEquals(50, maxKelements(new int[]{10,10,10,10,10}, 5));
    }
}
