package com.algorithm.leetcode.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author scott
 * @date 2023/8/6 10:48
 */
public class CanSplitArray_6953 {

    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() <= 2) {
            return true;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (i + 1 < nums.size() && nums.get(i) + nums.get(i + 1) >= m) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, canSplitArray(Lists.newArrayList(2, 3, 3, 2, 3), 6));
        Assert.assertEquals(false, canSplitArray(List.of(2, 1, 3), 5));
        Assert.assertEquals(true, canSplitArray(List.of(2, 2, 1), 4));
        Assert.assertEquals(true, canSplitArray(List.of(2 ), 5));
        Assert.assertEquals(true, canSplitArray(List.of(2,  1), 6));
    }
}