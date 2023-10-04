package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author scott
 * @date 2023/8/19 20:50
 */
public class FindAnagrams_438 {

    public List<Integer> findAnagrams(String s, String p) {
        int sl = s.length();
        int pl = p.length();

        if (sl < pl) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        // p字符串的字符出现频率数组
        int[] pChar = new int[26];
        // s的滑动窗口数组 和pl的长度一致
        int[] sChar = new int[26];
        for (int i = 0; i < pl; i++) {
            ++pChar[p.charAt(i) - 'a'];
            ++sChar[s.charAt(i) - 'a'];
        }

        if (Arrays.equals(pChar, sChar)) {
            list.add(0);
        }


        for (int i = 1 ; i <= sl - pl; i++) {
            --sChar[s.charAt(i - 1) - 'a'];
            ++sChar[s.charAt(i - 1 + pl) - 'a'];

            if (Arrays.equals(pChar, sChar)) {
                list.add(i);
            }
        }
        return list;
    }


//        public List<Integer> findAnagrams(String s, String p) {
//            int sLen = s.length(), pLen = p.length();
//
//            if (sLen < pLen) {
//                return new ArrayList<Integer>();
//            }
//
//            List<Integer> ans = new ArrayList<Integer>();
//            int[] sCount = new int[26];
//            int[] pCount = new int[26];
//            for (int i = 0; i < pLen; ++i) {
//                ++sCount[s.charAt(i) - 'a'];
//                ++pCount[p.charAt(i) - 'a'];
//            }
//
//            if (Arrays.equals(sCount, pCount)) {
//                ans.add(0);
//            }
//
//            for (int i = 0; i < sLen - pLen; ++i) {
//                --sCount[s.charAt(i) - 'a'];
//                ++sCount[s.charAt(i + pLen) - 'a'];
//
//                if (Arrays.equals(sCount, pCount)) {
//                    ans.add(i + 1);
//                }
//            }
//
//            return ans;
//        }




    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{0,6},
                findAnagrams("cbaebabacd", "abc").stream().mapToInt(Integer::valueOf).toArray());

        Assert.assertArrayEquals(new int[]{0,1,2},
                findAnagrams("abab", "ab").stream().mapToInt(Integer::valueOf).toArray());

        Assert.assertTrue(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaa").isEmpty());
    }
}