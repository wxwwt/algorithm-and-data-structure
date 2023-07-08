package com.algorithm.leetcode.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scott
 * @date 2023/6/27 22:02
 */
public class CombinationSum_39 {


    List<Integer> path = new ArrayList<>();

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target);
        return result;
    }

    public void backTracking(int[] candidates, int target) {
        if (path.stream().mapToInt(x -> x).sum() == target) {
            if (!result.contains(path)) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target || path.stream().mapToInt(x -> x).sum() + candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            backTracking(candidates, target);
            path.remove(path.size() - 1);
        }
    }


    @Test
    public void test1() {
        Assert.assertEquals(Lists.newArrayList(Lists.newArrayList(2, 2, 3), Lists.newArrayList(7)), combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}