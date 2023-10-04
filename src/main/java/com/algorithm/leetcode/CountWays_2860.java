package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class CountWays_2860 {
    

    public int countWays(List<Integer> nums) {
      Collections.sort(nums);
        int count = 0;
        int n = nums.size();
        int x = 0;
        if (n == 0) {
            return 0;
        }

        int i = 0;
        boolean f = true;
        while (i < n) {
            if (x + 1 > nums.get(i) ) {
                while(i < n && x + 1 > nums.get(i)) {
                    x++;
                    i++;
               }
                count++;
            }
            i++;
            x++;
        }

        if (0 < nums.get(0)) {
            count++;
        }
        return count;
    }
    @Test
    public void test1() {
        Assert.assertEquals(1, countWays(Lists.newArrayList(1,1,0,1)));
        Assert.assertEquals(0, countWays(Lists.newArrayList()));
        Assert.assertEquals(1, countWays(Lists.newArrayList(0)));
        Assert.assertEquals(2, countWays(Lists.newArrayList(1, 1)));
        Assert.assertEquals(3, countWays(Lists.newArrayList(6,0,3,3,6,7,2,7)));
        Assert.assertEquals(1, countWays(Lists.newArrayList(1)));
        Assert.assertEquals(3, countWays(Lists.newArrayList(6,0,3,3,6,7,2,7)));
    }
}
