package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/8/17 21:07
 */
public class MaxArea_11 {

    public int maxArea(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int s = 0 , e = n - 1;
        while (s < e) {
            int minValue = Math.min(height[e], height[s]);
            int area = (e - s) * minValue;
            max = Math.max(area, max);

//            if (height[e] > height[s]) {
//                s++;
//            } else {
//                e--;
//            }
            // 这里优化的点在于接下来的值如果小于当前的两块板子的最小值，就继续移动指针，因为area = minValue * 距离
            // 距离在变小，minValue却没有变大，那么area也只会更小，就不用计算了
            while (height[s] <= minValue && s < e) {
             s++;
            }

            while (height[e] <= minValue && s < e) {
                e--;
            }

        }
        return max;
    }

    @Test
    public void test1() {
        Assert.assertEquals(49, maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(1, maxArea(new int[]{1,2}));
        Assert.assertEquals(0, maxArea(new int[]{0,0}));
    }
}