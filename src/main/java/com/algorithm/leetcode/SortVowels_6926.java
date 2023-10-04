package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author scott
 * @date 2023/7/22 22:27
 */
public class SortVowels_6926 {

    static Set<Character> set = Set.of('A','E','I', 'O','U','a','e','i','o','u');

    public String sortVowels(String s) {

                char[] arr = s.toCharArray();
                List<Integer> list = new ArrayList<>();

            for (int i =0; i < s.length(); i++) {
                if (set.contains(arr[i])) {
                    list.add(i);

                }
            }

            if (list.isEmpty()) {
                return s;
            }

        char[] cArr = new char[list.size()];
            for (int i = 0; i < list.size();i++) {
                cArr[i] = arr[list.get(i)];
            }
           Arrays.sort(cArr);
            for (int i = 0;  i < list.size() ; i++) {
                arr[list.get(i)] = cArr[i];

            }
            return new String(arr);
    }

    @Test
    public void test1() {
        Assert.assertEquals("lYmpH", sortVowels( "lYmpH"));
        Assert.assertEquals("lEOtcede", sortVowels( "lEetcOde"));
    }
}