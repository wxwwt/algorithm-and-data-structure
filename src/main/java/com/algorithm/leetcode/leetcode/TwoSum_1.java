package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author scott
 * @date 2021/10/10 22:10
 */
public class TwoSum_1 {

    /**
     * 1.暴力遍历的话是n个数遍历(n^2-n)/2 是o(n^2)
     * 第1个数和剩下的数分别相加n-1
     * 第2个是 n-2次
     * 直到n-1个数是1次
     * n个数是0次
     * 是个等差数列，使用首项加尾项除以2 得出n个数遍历(n^2-n)/2 是o(n^2)
     *
     * 2.使用hash表来解决，因为总共输出只有两个数的下标，使用target减去遍历数组的
     * 当前值，看剩下的值在数组中是否存在。这个是否存在只要将数组遍历一遍，按照值-下标的
     * 键值对存储，就可以使用hash表来o(1)的复杂度来找到对应的数据。总共创建hash表遍历一次，
     * 查找数据遍历一次，总共2n次。是o(n)的时间复杂度。
     *
     * 备注：因为可以是无序的，可以把生成hashmap和遍历放到一起，时间可以更省
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
           int temp = target - nums[i];
           Integer value = map.get(temp);
           if (value != null && i != value) {
               result[0] = i;
               result[1] = value;
               break;
           }
        }
        return result;
    }

    public static int[] twoSumPlus(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target -nums[i])) {
                return new int[]{map.get(target -nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

   @Test
    public void test1() {
        int[] nums1 = new int[]{2,7,11,15};
        int target1 = 9;
        Assert.assertArrayEquals(twoSumPlus(nums1, target1), new int[]{0,1});

       int[] nums2 = new int[]{3,2,4};
       int target2 = 6;
       Assert.assertArrayEquals(twoSumPlus(nums2, target2), new int[]{1,2});

       int[] nums3 = new int[]{3,3};
       int target3 = 6;
       Assert.assertArrayEquals(twoSumPlus(nums3, target3), new int[]{0,1});
   }
}