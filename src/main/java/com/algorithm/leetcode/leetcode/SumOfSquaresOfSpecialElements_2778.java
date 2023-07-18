package com.algorithm.leetcode.leetcode;

/**
 * @author scott
 * @date 2023/7/9 10:20
 */
public class SumOfSquaresOfSpecialElements_2778 {

    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (n % (i+ 1) == 0) {
                result = result + nums[i] * nums[i];
            }
        }
        return  result;
    }


}