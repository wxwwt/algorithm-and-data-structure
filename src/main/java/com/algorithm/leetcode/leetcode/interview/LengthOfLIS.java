package com.algorithm.leetcode.leetcode.interview;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/9/17 20:48
 */
public class LengthOfLIS {

    /**
     * dp[i] 表示的是以arr[i]元素结尾的递增序列的长度最大值
     * arr[i]的值 比arr[j]还大 (0 <= j < i) 说明dp[i] = Max(dp[j] + 1, dp[i])
     * 这里解释一下为什么是dp[i] = Max(dp[j] + 1, dp[i]) 而不是dp[i] = dp[j] + 1
     * 举个栗子 [0,1,0,3,2,3]   此时开始遍历 i = 3， 3和1比较完的时候， dp[3] = dp[1] + 1 = 3,
     * 此时在遍历到3和0比较的时候，如果不是取最大值，那么arr[3] > arr[2] (3 > 2) , dp[3] = dp[2] + 1 = 2, 那么dp[3]就变成了2，就错了。
     * <p>
     * 时间复杂度：o(n^2)
     *
     * @param nums
     * @return
     */
    public int getLengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    /**
     * 看了题解才看明白的贪心+二分法
     * 用一个数组来保存最长的递增序列，要保证最长的递增序列，那么就要保证这个序列的前面的值，
     * 尽可能的小，这样序列才能尽可能的长
     * 如果nums[i] > 数组的最后一个元素，就直接加入到数组
     * 如果nums[i] <= 数组元素的最后一个元素，那么就找到大于nums[i], 同时是最小的元素，并替换掉
     * 最后数组的长度就是最长递增子序列的最大长度
     *
     * @param nums 初始数组
     * @return 数组长度
     */

    public int getLengthOfLIS(int[] nums) {
        int[] list = new int[nums.length];
        list[0] = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {

            if (list[length - 1] < nums[i]) {
                length++;
                list[length - 1] = nums[i];
            } else {

                boolean flag = true;
                int l = 0, r = length - 1, mid = 0;
                while (l <= r) {
                    mid = l + r >> 1;
                    if (nums[i] == list[mid]) {
                        flag = false;
                        break;
                    } else if (nums[i] > list[mid]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }

                if (flag) {
                    list[l] = nums[i];
                }
            }
        }
        return length;
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, getLengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        Assert.assertEquals(4, getLengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        Assert.assertEquals(1, getLengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        Assert.assertEquals(3, getLengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));

    }
}