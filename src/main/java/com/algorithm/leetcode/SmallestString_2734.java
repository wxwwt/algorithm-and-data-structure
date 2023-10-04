package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/7/28 8:42
 */
public class SmallestString_2734 {

    /**
     * 一开始没有注意，题目说必须替换一次，非空子串，所以是必须替换一次。
     * 如果都是a的话，就要把最后一个a替换为z，这样符合题意。
     * 如果不全是a的情况，就arr[i]--,直到遇到一个a
     * 设置了一个hasDeal来早点退出for循环
     *
     * @param s
     * @return
     */
    public String smallestString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ('a' == arr[i]) {
                // 特殊情况，遍历到最后一个字符是a还是没有替换 就把最后的a替换为z
                if (i == arr.length - 1) {
                    arr[i] = 'z';
                }
            } else {
                int j = i;
                while (j < arr.length && arr[j] != 'a') {
                    arr[j]--;
                    j++;
                }
                break;
            }
        }
        return new String(arr);
    }

    @Test
    public void test1() {
        Assert.assertEquals("az", smallestString("aa"));
        Assert.assertEquals("z", smallestString("a"));
        Assert.assertEquals("y", smallestString("z"));
        Assert.assertEquals("aaz", smallestString("aaa"));
        Assert.assertEquals("baabc", smallestString("cbabc"));
        Assert.assertEquals("abaab", smallestString("acbbc"));
        Assert.assertEquals("kddsbncd", smallestString("leetcode"));
    }
}