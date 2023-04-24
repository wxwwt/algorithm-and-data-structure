package com.algorithm.leetcode.completition;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author scott
 * @date 2023/4/22 15:00
 */
public class Test1 {

    public int[] supplyWagon(int[] supplies) {
        int count = 0;
        return doMerge(supplies, 0, supplies.length - 1, count);
    }

    public int[] doMerge(int[] arr, int start, int end, int count) {
        int min = Integer.MAX_VALUE;
        if (count == arr.length - arr.length / 2) {
            int[] result = new int[arr.length / 2];
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                   result[index++] = arr[i];
                }
            }
            return result;
        }

        int s1 = start, e1 = start;
        int index1 = start, index2 = start + 1;
        while (index2 <= end) {
            if (arr[index1] == 0) {
                index1++;
                continue;
            }

            if (arr[index2] == 0) {
                index2++;
                continue;
            }

            if (arr[index1] + arr[index2] < min) {
                s1 = index1;
                e1 = index2;
                min = arr[index1] + arr[index2];
            }
            index1++;
            index2++;
        }


        arr[s1] = arr[s1] + arr[e1];
        arr[e1] = 0;
        count++;
        return doMerge(arr, start, end, count);
    }

    @Test
    public void test1() {

//        supplyWagon(new int[]{7, 3, 6, 1, 8});
        supplyWagon(new int[]{6,2,2,6,9,8,5,7});
        Assertions.assertTrue(Lists.newArrayList(new int[]{5, 5}).containsAll(Lists.newArrayList(supplyWagon(new int[]{1, 3, 1, 5}))));
        Assertions.assertTrue(Lists.newArrayList(supplyWagon(new int[]{1, 3, 1, 5})).containsAll(Lists.newArrayList(new int[]{5, 5})));

    }
}