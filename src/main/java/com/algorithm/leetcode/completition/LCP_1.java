package com.algorithm.leetcode.completition;

/**
 * @author scott
 * @date 2023/7/30 10:08
 */
public class LCP_1 {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) {
                count++;
            }
        }
        return count++;
    }
}