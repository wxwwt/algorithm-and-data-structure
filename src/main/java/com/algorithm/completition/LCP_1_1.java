package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author scott
 * @date 2023/7/30 10:08
 */
public class LCP_1_1 {

    /**
     * 方法一：将所有的元素遍历一次都放入到set中，最后返回set的size就是元素的个数
     * @param nums
     * @return
     */
    public int numberOfPoints1(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> list : nums) {
            for (int i = list.get(0); i <= list.get(list.size() - 1); i++) {
                set.add(i);
            }
        }
        return set.size();
    }

    /**
     * 方法二：如果这道题目的数据量特别大的情况下，可能全部遍历一次就会超时，
     * 可以使用查分数组，用来区间快速加减操作。
     * @param nums
     * @return
     */
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> list : nums) {
            for (int i = list.get(0); i <= list.get(list.size() - 1); i++) {
                set.add(i);
            }
        }
        return set.size();
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, numberOfPoints(List.of(List.of(1,3))));
        Assert.assertEquals(7, numberOfPoints(List.of(List.of(1,3), List.of(5,8))));
        Assert.assertEquals(7, numberOfPoints(List.of(List.of(3,6), List.of(1,5), List.of(4,7))));
    }
}