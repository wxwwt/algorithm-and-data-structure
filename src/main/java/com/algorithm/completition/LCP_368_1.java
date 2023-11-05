package com.algorithm.completition;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCP_368_1 {

    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        long sum = n;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums.get(i));
            for (int j = i + 1; j < n; j++) {
                set.add(nums.get(j));
                sum += set.size() * set.size();
            }
            set.clear();
        }
        return (int)(sum % 1000_000_007);
    }

    @Test
    public void test() {
        Assert.assertEquals(15, sumCounts(Lists.newArrayList(1,2,1)));
    }
}
