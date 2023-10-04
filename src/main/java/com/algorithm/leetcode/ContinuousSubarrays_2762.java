package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

/**
 * @author scott
 * @date 2023/7/2 11:04
 */
public class ContinuousSubarrays_2762 {


    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        var t = new TreeMap<Integer, Integer>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            t.merge(nums[right], 1, Integer::sum);
            while (t.lastKey() - t.firstKey() > 2) {
                int y = nums[left++];
                if (t.get(y) == 1) t.remove(y);
                else t.merge(y, -1, Integer::sum);
            }
            ans += right - left + 1;
        }
        return ans;
    }




    @Test
    public void test1() {
        Assert.assertEquals(8, continuousSubarrays(new int[]{5, 4, 2, 4}));
        Assert.assertEquals(6, continuousSubarrays(new int[]{1,2,3}));
    }
}