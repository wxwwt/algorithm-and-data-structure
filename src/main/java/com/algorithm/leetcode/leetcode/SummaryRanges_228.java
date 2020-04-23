package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenchuang
 * @since 2020-04-16
 */
public class SummaryRanges_228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> stringList = new ArrayList<>();
        int startPoint = -1;
        int endPoint = -1;
        if (nums.length == 1) {
            stringList.add(nums[0] + "");
            return stringList;
        }

        for (int i = 1; i < nums.length; i++) {
            //  if ((long) nums[i] - (long) nums[i - 1] > 1) {
            // 一开始是上面这么写的 因为[-2147483648->-2147483647, 2147483647]
            // 计算减法会溢出 结果是错的
            // 后来参考了别人的写法 发现加法是可以避免这种问题的
            if (1 + nums[i - 1] < nums[i]) {
                startPoint = endPoint + 1;
                endPoint = i - 1;
                // 如果两个指针指向同一个数据 那就直接转字符串
                if (startPoint == endPoint) {
                    stringList.add(nums[startPoint] + "");
                } else {
                    stringList.add(nums[startPoint] + "->" + nums[endPoint]);
                }

                // 最后剩一个数 相差大于1 就是endPoint 是数组最大下标减1 (nums.length - 1 -1) 就单独加在后面
                if (endPoint == nums.length - 2) {
                    stringList.add(nums[nums.length - 1] + "");
                }
            } else if (i == nums.length - 1) {
                // 这个分支包含了
                // 1.如果到最后也没有一个差距大于1的 整个就一个递增数组 直接输出 [0,1,2,3]这种情况
                // 2.最后一个数字和倒数第二个数字 相差为1的情况 [0,1,2,4,5]
                stringList.add(nums[endPoint + 1] + "->" + nums[nums.length - 1]);
            }
        }
        return stringList;
    }

    @Test
    public void test1() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        Assert.assertEquals("[0->2, 4->5, 7]", summaryRanges(nums).toString());
    }

    @Test
    public void test2() {
        // 整个就一个递增数组
        int[] nums = {0, 1, 2, 3, 4, 5};
        Assert.assertEquals("[0->5]", summaryRanges(nums).toString());
    }

    @Test
    public void test3() {
        // 最后的数字和前面相差为1的情况
        int[] nums = {0, 1, 2, 4, 5};
        Assert.assertEquals("[0->2, 4->5]", summaryRanges(nums).toString());
    }

    @Test
    public void test4() {
        // 单个数字
        int[] nums = {-1};
        Assert.assertEquals("[-1]", summaryRanges(nums).toString());
    }

    @Test
    public void test5() {
        // 空数组
        int[] nums = {};
        Assert.assertEquals("[]", summaryRanges(nums).toString());
    }

    @Test
    public void test6() {
        // 空数组
        int[] nums = {1, 3};
        Assert.assertEquals("[1, 3]", summaryRanges(nums).toString());
    }

    @Test
    public void test7() {
        // 空数组
        int[] nums = {1, 2, 4};
        Assert.assertEquals("[1->2, 4]", summaryRanges(nums).toString());
    }

    @Test
    public void test8() {
        int[] nums = {-2147483648, -2147483647, 2147483647};
        Assert.assertEquals("[-2147483648->-2147483647, 2147483647]", summaryRanges(nums).toString());
    }

    @Test
    public void test9() {
        int a = 2147483647;
        int b = -2147483647;
        int c = a + 1;
    }
}
