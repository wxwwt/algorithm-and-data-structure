package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/10/25 19:20
 */
public class FoundEqualsArray {

    /**
     * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     *
     * 形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。
     *
     *
     * 示例 1：
     *
     * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
     * 输出：true
     * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
     * @param arr
     * @return
     */

    public Boolean solution (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int total1 = cal(arr, 0, i);
                int total2 = cal(arr, i + 1, j);
                int total3 = cal(arr, j + 1, arr.length - 1);
                if (total1 == total2 && total2 == total3) {
                    return true;
                }
            }

        }
        return false;
    }

    public int cal(int[] arr, int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            total += arr[i];
        }
        return total;
    }

    @Test
    public void test1() {
        Assert.assertEquals(solution(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}), true);
        Assert.assertEquals(solution(new int[]{0,2,1}), false);
    }
}