package com.algorithm.leetcode.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scott
 * @date 2023/7/9 10:21
 */
public class LCP_T03 {


        int result = 0;


    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
       dfs(nums1, nums2, 0,0,0);
        return result;
    }

    public void dfs(int[] nums1, int[] nums2, int index, int pre, int count) {
        // 如果pre > Max.(nums1[i], nums[i]) 则要重新计算
        // 如果 pre <= Min.(nums1[i], nums2[i]) 取nums[i]或者nums2[i]中小的那个值 继续走
        // 如果 Min.(nums1[i], nums2[i]) <  pre <= Max.(nums1[i], nums2[i]) 就使用max的值 继续往下走
        int max = Math.max(nums1[index], nums2[index]);
        int min = Math.min(nums1[index], nums2[index]);
        if (pre <= min) {
            dfs(nums1, nums2, index + 1, min, count++);
            result = Math.max(count, result);
        } else {
                if (pre > max) {
                    result = Math.max(count, result);
                    count = 0;
                    dfs(nums1, nums2, index + 1, 0, count);

                } else {
                    dfs(nums1, nums2, index + 1, max, count++);
                    result = Math.max(count, result);
                }
        }
    }



    @Test
    public void test1() {

        Assert.assertEquals(4, maxNonDecreasingLength(new int[]{1,3,2,1}, new int[]{2,2,3,4}));
//        Assert.assertEquals(2, maxNonDecreasingLength(new int[]{8,7,4}, new int[]{13,4,4}));

    }
}