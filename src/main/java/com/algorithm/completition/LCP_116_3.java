package com.algorithm.completition;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCP_116_3 {

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int s = 0;
        int count = -1;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {

            if (sum + nums.get(i) <= target) {
                sum = sum + nums.get(i);
                set.add(nums.get(i));
            } else  {
                if (set.contains(sum + nums.get(i) - target)) {
                    return i -s +1;
                }
                while (sum + nums.get(i)> target) {
                    sum -= nums.get(s);
                    s++;
                }
                sum = sum + nums.get(i);
            }
            if (sum == target) {
                return i - s + 1;
            }
        }
        return count;
    }

    @Test
    public void test() {
//        Assert.assertEquals(1, lengthOfLongestSubsequence(Lists.newArrayList(2,3), 3));
//        Assert.assertEquals(3, lengthOfLongestSubsequence(Lists.newArrayList(1,2,3,4,5), 9));
        Assert.assertEquals(6, lengthOfLongestSubsequence(Lists.newArrayList(2,13,7,3,14,8,11,10,7,13), 44));

    }
}
