package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author scott
 * @date 2022/4/7 23:31
 */
public class ArrayOfDoubledPairs_954 {


    /**
     * 找出数组中成对的的二倍数组对，第一反应就是求每个数组的值看，是否有当前值的2倍或者1/2，如果每个值有
     * 2倍数或者1/2的数，那么就返回true。然后这个2倍数或者1/2使用hashmap存一下，来判断。
     * 后来又想到这里正数和负数是不一样的，正数的2倍数是比当前值大的，负数的2被其实是比当前值小的，所以如果是负数
     * 的话，其实是求后面的值是不是它的1/2，正数是求后面的值是否当前值的2倍。（想到这里所以要对arr进行一次排序）
     * 使用一个set来存储整个数据，如果遍历arr的当前值和2被或者1/2在set中不存在就设置flag为false，遍历完只有flag
     * 是false就说明有数字没有成对。
     *
     * @param arr
     * @return
     */
    public boolean canReorderDoubled(int[] arr) {
        List<Integer> tempList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        set.addAll(tempList);
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= 0) {
                // 如果存在成对的数 就移除这两个数
                if ((arr[i] == 0 && arr[i + 1] == 0) || (set.contains(arr[i] * 2) && arr[i] != arr[i + 1])) {
                    ++i;
                } else {
                    flag = false;
                }
            } else {
                if ((arr[i] == 0 && arr[i + 1] == 0) || (set.contains(arr[i] / 2) && arr[i] != arr[i + 1])) {
                    ++i;
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }

    @Test
    public void test1() {
        Assert.assertFalse(canReorderDoubled(new int[]{3, 1, 3, 6}));
        Assert.assertFalse(canReorderDoubled(new int[]{2, 1, 2, 6}));
        Assert.assertFalse(canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4}));

        Assert.assertTrue(canReorderDoubled(new int[]{4, -2, 2, -4}));
        Assert.assertTrue(canReorderDoubled(new int[]{2, 4, 0, 0, 8, 1}));

    }
}