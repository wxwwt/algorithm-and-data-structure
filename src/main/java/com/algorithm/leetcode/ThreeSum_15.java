package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author scott
 * @date 2021/10/16 18:22
 */
public class ThreeSum_15 {

    /**
     * 写完后发现题解和我的思路基本一样，不过写法比我优秀
     * 列一下网上有人写的题解，思路是一样的
     * 排序 + 双指针
     * 本题的难点在于如何去除重复解。
     * <p>
     * 算法流程：
     * 特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。
     * 对数组进行排序。
     * 遍历排序后数组：
     * 若 nums[i]>0，nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
     * 对于重复元素：跳过，避免出现重复解
     * 令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
     * 当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
     * 若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
     * 若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0) {
            return result;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int startIndex = i + 1;
            int endIndex = nums.length - 1;
            int target = -nums[i];

            while (startIndex < endIndex) {
                // 首尾的值比target大就挪动尾指针 小就挪动首指针
                if (nums[startIndex] + nums[endIndex] > target) {
                    --endIndex;
                } else if (nums[startIndex] + nums[endIndex] < target) {
                    ++startIndex;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[startIndex], nums[endIndex]);
                    if (result.isEmpty() || !result.get(result.size() - 1).equals(temp)) {
                        result.add(temp);
                    }
                    --endIndex;
                    if (startIndex == endIndex) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 优化后的去除重复解的代码
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        if (nums[0] > 0) {
            return result;
        }

        for (int i = 0; i < nums.length - 1; i++) {


            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int startIndex = i + 1;
            int endIndex = nums.length - 1;
            int target = 0;

            while (startIndex < endIndex) {
                // 首尾的值比target大就挪动尾指针 小就挪动首指针
                if (nums[startIndex] + nums[endIndex] + nums[i] > target) {
                    --endIndex;
                } else if (nums[startIndex] + nums[endIndex] + nums[i] < target) {
                    ++startIndex;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[startIndex], nums[endIndex]);
                    result.add(temp);
                    // 上面的去除重复解是根据已经添加的数据 这里是使用对比值来去重
                    // 这个去重要放到 ++startIndex --endIndex前面 否则++ --会把正确的结果漏掉
                    while (startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]) {
                        ++startIndex;
                    }

                    while (startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]) {
                        --endIndex;
                    }
                    ++startIndex;
                    --endIndex;
                }
            }
        }
        return result;
    }

    @Test
    public void test1() {
        Assert.assertEquals(new ArrayList<>(), threeSum2(new int[]{}));
        Assert.assertEquals(new ArrayList<>(), threeSum2(new int[]{0}));
        Assert.assertEquals(new ArrayList<List<Integer>>() {{
            add(Arrays.asList(0, 0, 0));
        }}, threeSum2(new int[]{0, 0, 0}));
        Assert.assertEquals(new ArrayList<List<Integer>>() {{
            add(Arrays.asList(0, 0, 0));
        }}, threeSum2(new int[]{0, 0, 0, 0}));

        Assert.assertEquals(new ArrayList<List<Integer>>() {
            {
                add(Lists.newArrayList(-1, -1, 2));
                add(Lists.newArrayList(-1, 0, 1));
            }
        }, threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));


        Assert.assertEquals(new ArrayList<List<Integer>>() {{
            add(Lists.newArrayList(-2, 0, 2));
            add(Lists.newArrayList(-2, 1, 1));
        }}, threeSum2(new int[]{-2, 0, 1, 1, 2}));
    }
}