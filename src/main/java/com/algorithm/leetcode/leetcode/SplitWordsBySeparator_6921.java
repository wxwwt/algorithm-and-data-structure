package com.algorithm.leetcode.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scott
 * @date 2023/4/22 15:00
 */
public class SplitWordsBySeparator_6921 {


    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String s : words) {
         String[] temp = s.split("\\" + separator);
         for (String  a : temp) {
             if (a != "") {
                 list.add(a);
             }
         }
        }
        return list;
    }

    @Test
    public void test1() {
        splitWordsBySeparator(List.of("$easy$","$problem$"), '$');
        splitWordsBySeparator(List.of("one.two.three","four.five","six"), '.');
    }
}