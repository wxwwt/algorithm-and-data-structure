package com.algorithm.leetcode.leetcode;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author scott
 * @date 2023/3/12 22:28
 */
public class HouseRobberII_213 {


    /**
     * 使用动态规划，老规矩还是先找找规律
     * dp[i]当前到底i间房能偷到的最大金额
     * dp[0] = nums[0]
     * dp[1] = Max(num[0], nums[1])
     * dp[2] = Max(nums[0], nums[2])
     * dp[3] = 1~i的最大值，  当选择第i个房间, 就不能选择第0间房，所以最大值是从下标1到i间房的最大值
     *         dp[i - 1]                   当没有选择第i个房间
     *
     * dp[4] = 1~i              当选择了第i个房间
     *          dp[i - 1]                                       当没有选择第i个房间，就是dp[i-1]
     *
     *
     * 可以直接调用HouseRobber的方法，只是稍微改造下，是传入数据和起始，结束的下标
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(recall(nums, 0, nums.length - 2), recall(nums, 1, nums.length- 1));
    }






    public int recall(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = end - start + 1;
        if (length == 1) {
            return nums[start];
        }

        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < length + start; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    @Test
    public void test1() {
        Assertions.assertEquals(3 , rob(new int[]{2,3,2}));
        Assertions.assertEquals(4 , rob(new int[]{1,2,3,1}));
        Assertions.assertEquals(3 , rob(new int[]{1,2,3}));
        Assertions.assertEquals(3 , rob(new int[]{1,2,1,1}));
//        [1,2,1,1]
    }
}