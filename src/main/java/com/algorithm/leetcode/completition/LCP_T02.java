package com.algorithm.leetcode.completition;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/9 10:20
 */
public class LCP_T02 {

    int maxCount = -1;

    public int maximumJumps(int[] nums, int target) {
            if (target <= 0) {
                return -1;
            }

            int count = 0;
            int s = 0, e = s + 1;
            for (int i = 0; i < nums.length && e < nums.length; i++) {
                if (Math.abs(nums[e] -nums[s]) <= target) {
                        count++;
                    if (e == nums.length - 1) {
                        break;
                    }
                        s = e;
                        e = s + 1;
                } else {
                    if (e == nums.length - 1) {
                        break;
                    }
                   e++;
                }
            }

            if (Math.abs(nums[e] -nums[s]) > target) {
                return -1;
            }

            if (Math.abs(nums[e] -nums[s]) <= target) {
                return count;
            }
            return count;
    }


    public void backTracking(int s, int e, int count, int[] nums, int target) {
        if (e == nums.length - 1) {
            maxCount = Math.max(count, maxCount);
            return;
        }


        for (int i = 0; i < nums.length && e < nums.length; i++) {
//            backTracking();
            if (Math.abs(nums[e] -nums[s]) <= target) {
                count++;

                s = e;
                e = s + 1;
            } else {
                if (e == nums.length - 1) {
                    break;
                }
                e++;
            }
        }
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, maximumJumps(new int[]{1,3,6,4,1,2}, 2));
        Assert.assertEquals(-1, maximumJumps(new int[]{1,3,6,4,1,2}, 0));
        Assert.assertEquals(-1, maximumJumps(new int[]{0,2,1,3}, 1));

    }
}