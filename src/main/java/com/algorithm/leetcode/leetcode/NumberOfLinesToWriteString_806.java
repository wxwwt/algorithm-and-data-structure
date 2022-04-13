package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shenchuang
 * @date 2022/4/12 11:22 PM
 */
public class NumberOfLinesToWriteString_806 {

    /**
     * 这道题好像都没有什么特别要说的点，就是按照题目的意思去写代码就行了。
     * 遍历s的字符数组直到结束：
     * 如果已经使用的长度curLength，在加入当前字符character后，占用的单位超过了100，就换一行，使用单位重新计算，curLength变成当前字符占用的单位
     * 如果没有超过100，就curLength = curLength + 当前字符长度
     * 时间复杂度：O(n), 遍历了一次s
     * 空间复杂度：O(1), 仅使用了常数级的变量
     *
     * @param widths
     * @param s
     * @return
     */
    public int[] numberOfLines(int[] widths, String s) {
        int curLength = 0;
        int lineNum = 1;
        for (int i = 0; i < s.length(); i++) {
            int temp = curLength + widths[s.charAt(i) - 'a'];
            if (temp > 100) {
                // 超过100单位了就换行 并且curLength重置
                ++lineNum;
                curLength = widths[s.charAt(i) - 'a'];
            } else {
                curLength = temp;
            }

        }
        return new int[]{lineNum, curLength};
    }

    @Test
    public void test1() {
        int[] arr1 = numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz");
        Assert.assertEquals(3, arr1[0]);
        Assert.assertEquals(60, arr1[1]);

        int[] arr2 = numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa");
        Assert.assertEquals(2, arr2[0]);
        Assert.assertEquals(4, arr2[1]);
    }
}
