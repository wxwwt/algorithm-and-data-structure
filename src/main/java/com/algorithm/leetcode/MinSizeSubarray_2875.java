package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinSizeSubarray_2875 {

    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        long sum ;
        int ans = Integer.MAX_VALUE;
        if (total == target) {
            return n;
        }
        if (target > total) {
            sum = target % total;
        } else {
            sum = target;
        }

        int l = 0 ;
        int tSum = 0;
        // target取余之后，去掉中间重复的数组，sum可简化到两个数组中找到最小的等于target的长度
        for (int i = 0; i < 2 * n; i++) {
            tSum += nums[i % n];
            if (tSum < sum) {

            } else if (tSum > sum) {
                while (tSum > sum) {
                    tSum -= nums[l % n];
                    l++;
                }
            }

            if (tSum == sum) {
                ans = Math.min(ans, i - l + 1);
            }
        }
        // 没有找到的情况
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        // 找到了数值的情况
        return  (target / total) * n + ans;
    }


    @Test
    public  void test() {
        Assert.assertEquals(2, minSizeSubarray(new int[]{1,2,3},5));
        Assert.assertEquals(2, minSizeSubarray(new int[]{1,1,1,2,3}, 4));
        Assert.assertEquals(-1, minSizeSubarray(new int[]{2,4,6,8}, 3));
        Assert.assertEquals(9, minSizeSubarray(new int[]{2,1,5,7,7,1,6,3}, 39));
    }
}
