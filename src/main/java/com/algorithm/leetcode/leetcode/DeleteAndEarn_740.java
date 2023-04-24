package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/3/29 21:52
 */
public class DeleteAndEarn_740 {


    /**
     * 没想出来，最后看了别人的题解，原来这道题竟然可以简化为打家劫舍的版本：
     * 把数组排序，然后选择一个数字因为会删除相邻的两个数字，所以其实跟打家劫舍很像（不能偷相邻的房间）
     * 然后因为如果选择了一个数字x，那么这个数组中的其他x，也一定会被选择，所以可以提前就把重复的数值的值累加起来，
     * 或者记录下数字x出现的次数c。接着可以构建一个数组arr，这里我们用累加的方式，arr的下标就是nums里面出现的数值，
     * arr[i]数值就是数字x的累加值。
     * 接着就变成了打家劫舍的数组arr，使用跟之前的动态规划就能解决。因为
     * arr的下标就是nums里面数值，所以要找到最大值，然后长度加1，因为题目给出1 <= nums[i] <= 104，0的位置是没有元素的。
     * 状态转移方程：
     * dp[i] = dp[i-1]   没有选第arr[i]
     * dp[i-2] + arr[i]  选择了第arr[i]
     * <p>
     * 最优子结构：
     * dp[i] = Max.(dp[i - 1], dp[i - 2] + arr[i])
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn1(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]] != 0) {
                arr[nums[i]] += nums[i];
            } else {
                arr[nums[i]] = nums[i];
            }
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[dp.length - 1];
    }

    /**
     * 方式二就是下面的动态规划修改为滚动数组，用来节省空间
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]] != 0) {
                arr[nums[i]] += nums[i];
            } else {
                arr[nums[i]] = nums[i];
            }
        }

        int first = arr[0];
        int second = Math.max(arr[0], arr[1]);
        int temp = 0;
        for (int i = 2; i < arr.length; i++) {
           temp =  Math.max(second, first + arr[i]);
           first = second;
           second = temp;

        }
        return second;
    }

    @Test
    public void test1() {
        Assert.assertEquals(6, deleteAndEarn(new int[]{3,4,2}));
        Assert.assertEquals( 1+3+16+18, deleteAndEarn(new int[]{1,2,3,15,16,17,18}));
    }


}