package com.algorithm.leetcode.completition;

/**
 * @author scott
 * @date 2023/7/9 10:20
 */
public class LCP_T01 {

    public int theMaximumAchievableX(int num, int t) {
        for (int i = 0; i < t; i++) {
            num += 2;
        }
        return num;
    }


}