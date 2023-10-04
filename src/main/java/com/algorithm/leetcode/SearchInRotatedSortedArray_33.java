package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

/**
 * 搜索旋转数组 LC33
 * @author scott
 * @date 2022/9/19 22:22
 */
public class SearchInRotatedSortedArray_33 {

    /**
     * 一开始没有想到局部有序也可以直接使用二分查找来解决
     * 思路是想先找到旋转点，然后对两边分别进行二分查找，但是找旋转点这个花的时间就已经是O(n)，然后就看了下题解。
     * 直接对数组使用二分查找，mid的左边或者右边，一定至少有一部分是严格有序递增的，如果target不在这个严格有序递增的部分，
     * 就去另外一个部分，继续使用二分，循环往复。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0 , r = nums.length - 1,  mid =  (nums.length - 1) / 2;
        while(l <= r) {

            if (nums[mid] == target) {
                return mid;
            }

            // 如果左边是递增区间
            if (nums[l] <= nums[mid]) {
                // target在递增区间内
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    // target在非递增区间内
                    l = mid + 1;
                }
            } else {
                // 右边是递增区间
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    // target在左边的非递增区间内
                    r = mid - 1;
                }
            }
            mid = l + (r - l) / 2;
        }

        return -1;
    }


    public int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;


    }



    @Test
    public void test1() {
        Assert.assertEquals(4, search(new int[]{4,5,6,7,0,1,2}, 0));
        Assert.assertEquals(-1, search(new int[]{4,5,6,7,0,1,2}, 3));
        Assert.assertEquals(-1, search(new int[]{1}, 0));

        Assert.assertEquals(1, search2(new int[]{3,1}, 1));
        Assert.assertEquals(-1, search(new int[]{1,3,5}, 0));
        Assert.assertEquals(2, search(new int[]{4,5,1,2,3}, 1));
    }
}