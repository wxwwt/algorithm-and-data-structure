package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author scott
 * @date 2023/7/20 22:45
 */
public class NumMatchingSubseq_792 {

    public int numMatchingSubseq(String s, String[] words) {
        //  定义26个字母的数组
        Deque<String>[] arr = new Deque[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayDeque<>();
        }
            // 把单词根据首字母放到26个字母数组中去

        for (int i = 0; i < words.length; i++) {
             arr[words[i].charAt(0) - 'a'].add(words[i]);
        }


        int count = 0;
        for (char sc : s.toCharArray()) {
            int index = sc - 'a';
            Deque<String> queue = arr[index];
            int size = queue.size();
           for( ;size > 0; size--) {
                // 如果是最后一个字符 被划掉就证明是子序列
                if (queue.peek().length() == 1) {
                    count++;
                    queue.poll();
                } else {
                    // 删除首字母 在根据首字母放回数组
                    String temp = queue.poll();
                    temp = temp.substring(1);
                    arr[temp.charAt(0) - 'a'].add(temp);
                }
            }
        }
        return count;
    }


    public boolean isSubseq(char[] arr, String cur) {
        int index = 0;
        char[] temp = cur.toCharArray();
        for (int j = 0; j < temp.length; j++) {


            if (temp[j] == arr[index]) {


                j++;
                index++;

                if (j == temp.length - 1 && temp[temp.length - 1] == arr[index]) {
                    return true;
                }
            } else {
                while (index < arr.length && temp[j] != arr[index]) {
                    index++;
                    if (j == temp.length - 1 && temp[temp.length - 1] == arr[index]) {
                        return true;
                    }
                }
                index++;
            }
        }
        return false;
    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }


    @Test
    public void test1() {
//        Assert.assertEquals(0, numMatchingSubseq("abcde", new String[]{"kkl"}));
        Assert.assertEquals(3, numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        Assert.assertEquals(2, numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));

    }
}