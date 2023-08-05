package com.algorithm.leetcode.completition;

import java.util.HashSet;
import java.util.Set;

/**
 * @author scott
 * @date 2023/7/30 10:08
 */
public class LCP_2 {

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set  = new HashSet<>();
        int result = 0;
            for (int i = 0 ;i < nums.length;i++) {
                set.add(nums[i]);
            }

            int s = 0 ,e = set.size() - 1;
            for (int i = 0; i < nums.length;i++) {
                Set<Integer> tSet = new HashSet<>();

                for (int j = 0 ; j < e; j++) {
                            tSet.add(nums[j]);
               }

                if (tSet.containsAll(set) && set.containsAll(tSet)) {
                    // 从最小的完全数组往两边阔开
                    int sD = s - i;
                    int eD = nums.length - e;
                    result = eD + sD + 1;
                }
            }
            return result;
    }
}