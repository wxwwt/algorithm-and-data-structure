package com.algorithm.leetcode;

/**
 * 找到两个排序数组（长度为n和m）的中位数 要求时间复杂度是O(log(m+n))
 *
 * @author scott
 * @date 2019/5/30 21:53
 */
public class MedianOfTwoSortedArrays_4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] longer;
        int[] shorter;
        int isOdd = nums1.length + nums2.length & 1;
        int median1 = 0;
        int median2 = 0;
        if (isOdd == 1) {
            // 因为数组下标原因 这里的中位数都默认减了1
            median1 = (nums1.length + nums2.length) / 2;
        } else {
            median1 = (nums1.length + nums2.length) / 2;
            median2 = median1 - 1;
        }
        if (nums1.length > nums2.length) {
            longer = nums1;
            shorter = nums2;
        } else {
            longer = nums2;
            shorter = nums1;
        }

        // 如果长数组的最后一个数小于短数组 说明两数组合起来都是顺序的 中位数直接取
        if (longer[longer.length - 1] < shorter[0]) {
            if (isOdd == 1) {
                return longer[median1];
            } else {
                if (nums1.length == nums2.length) {
                    return (longer[longer.length] + shorter[0]) / 2d;
                }
                return (longer[median1] + longer[median2]) / 2d;
            }
        }

        for (int i = 0; i < shorter.length; i++) {
            if (longer[longer.length - 1] < shorter[0]) {
            }
            return 1d;
        }
        return 1d;
    }
}