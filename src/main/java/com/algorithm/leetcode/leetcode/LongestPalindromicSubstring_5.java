package com.algorithm.leetcode.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最长子回文串
 *
 * @author scott
 * @date 2019/5/20 22:29
 */
public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {
        System.out.println(LongestPalindromicSubstring_5.longestPalindrome("ababa"));
        System.out.println(LongestPalindromicSubstring_5.longestPalindrome("babad"));
        System.out.println(LongestPalindromicSubstring_5.longestPalindrome("cbbd"));
        System.out.println(LongestPalindromicSubstring_5.longestPalindrome(""));

        System.out.println(LongestPalindromicSubstring_5.longestPalindrome("aaaa"));
        System.out.println(LongestPalindromicSubstring_5.longestPalindrome("aaaaa"));
        System.out.println(LongestPalindromicSubstring_5.longestPalindrome("abcdfg"));
        /**
         * 输出结果：
         * ababa
         * bab
         * bb
         *
         * aaaa
         * aaaaa
         * a
         */

    }

    public static String longestPalindrome(String s) {
        if (null == s || s.length() > 1000) {
            return null;
        }
        if (s.equals("")) {
            return "";
        }
        char[] charArr = s.toCharArray();
        // 使用双向队列来保存最大的子串
        Deque<Character> deque = new ArrayDeque<>();
        Character[] maxArr = new Character[]{charArr[0]};
        String longestStr;
        int maxInt = 0;
        for (int i = 0; i < charArr.length; i++) {
            int head = 0;
            int tail = 0;
            // 偶数回文  用来判断回文数的两个数字的下标不能超过最大下标
            if (i + 1 <= charArr.length - 1 && charArr[i] == charArr[i + 1]) {
                deque.clear();
                head = i;
                tail = i + 1;
                while (head >= 0 && tail <= charArr.length - 1) {
                    if (charArr[head] == charArr[tail]) {
                        deque.addFirst(charArr[head]);
                        deque.addLast(charArr[tail]);
                        --head;
                        ++tail;
                    } else {
                        break;
                    }
                }
                if (deque.size() > maxInt) {
                    maxInt = deque.size();
                    maxArr = deque.toArray(new Character[deque.size()]);
                }
            }
            // 奇数回文
            if (i + 2 <= charArr.length - 1 && charArr[i] == charArr[i + 2]) {
                deque.clear();
                head = i;
                tail = i + 2;
                // 奇数的把中间轴对称的数先放入双向队列
                deque.addFirst(charArr[i + 1]);
                while (head >= 0 && tail <= charArr.length - 1) {
                    if (charArr[head] == charArr[tail]) {
                        deque.addFirst(charArr[head]);
                        deque.addLast(charArr[tail]);
                        --head;
                        ++tail;
                    } else {
                        break;
                    }
                }

                if (deque.size() > maxInt) {
                    maxInt = deque.size();
                    maxArr = deque.toArray(new Character[deque.size()]);
                }
            }
        }
        char[] bb = new char[1000];
        for (int j = 0; j < maxArr.length; j++) {
            bb[j] = maxArr[j];
        }
        longestStr = String.valueOf(bb).trim();
        return longestStr;
    }
}