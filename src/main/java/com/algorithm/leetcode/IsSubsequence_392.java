package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/21 8:22
 */
public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }


        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();
        int index = 0;
        for (int i = 0 ;i < tArr.length;i++) {
            if (index == sArr.length) {
                return true;
            }

                if (tArr[i] == sArr[index]) {
                    index++;
                }
        }
        return index == sArr.length;
    }

    @Test
    public void test1() {


        Assert.assertEquals(true, isSubsequence("abc", "ahbgdc"));

        Assert.assertEquals(true, isSubsequence("abd", "abcde"));
        Assert.assertEquals(false, isSubsequence("axc", "ahbgdc"));
        Assert.assertEquals(true, isSubsequence("", "ahbgdc"));
        Assert.assertEquals(false, isSubsequence("dfsa", ""));
        Assert.assertEquals(true, isSubsequence("", ""));

    }
}