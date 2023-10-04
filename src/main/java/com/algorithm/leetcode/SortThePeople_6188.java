package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2022/9/25 10:37
 */
public class SortThePeople_6188 {

    /**
     * 使用treeMap进行排序，然以倒序输出，因为默认treemap是升序排列的，
     * 题目要求是按照身高从大到小输出。
     * 注：名字可能重复，要按照身高作为key
     * @param names
     * @param heights
     * @return
     */
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        String[] arr = new String[names.length];
        int i = arr.length - 1;
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            arr[i] = item.getValue();
            i--;
        }
        return arr;
    }

    /**
     * 后来发信原来treemap还可以指定倒序排列，程序改进一波
     */
    public String[] sortPeople2(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }


        int i = 0;
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            names[i] = item.getValue();
            i++;
        }
        return names;
    }



    @Test
    public void test1() {
        Assert.assertEquals(new String[]{"Mary", "Emma", "John"}, sortPeople2(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170}));
    }


    }