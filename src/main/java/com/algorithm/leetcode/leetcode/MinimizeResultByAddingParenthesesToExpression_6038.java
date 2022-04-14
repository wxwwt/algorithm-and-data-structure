package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/4/10 11:51
 */
public class MinimizeResultByAddingParenthesesToExpression_6038 {

    /**
     * 思路比较简单，就是从字符串出发找到中间的+号，然后从左右两边，选一边开始遍历，是尝试加括号的位置。
     * 以247+38为例，以右边开始，右边就是3)8，
     * 左边对应的括号内最短的数字是24(7,然后计算 24*（7+3）*8，
     * 然后做移动左边的括号变成2*(47+3)*8,
     * 计算完继续移动为(247+3)*8,
     * 这样左边遍历结束，开始遍历右边，
     * 变成24*(7+38)*1.
     * 注意：当括号外面没有数字的时候乘以1就行了。
     * 把每次最小的值储存下来，并记录两个括号的下标，最后拼出来字符串即可
     *
     * @param expression
     * @return
     */
    public String minimizeResult(String expression) {
        int min = Integer.MAX_VALUE;
        int plusIndex = expression.indexOf("+");
        String left = expression.substring(0, plusIndex);
        String right = expression.substring(plusIndex + 1);
        int leftParenthesesIndex = 0;
        int rightParenthesesIndex = right.length();
        for (int i = 0; i < right.length(); i++) {
            for (int j = left.length(); j > 0; j--) {
                int rightInside = Integer.parseInt(right.substring(0, i + 1));
                int rightOutside = !"".equals(right.substring(i + 1)) ? Integer.parseInt(right.substring(i + 1)) : 1;
                int leftInSide = Integer.parseInt(left.substring(j - 1));
                int leftOutSide = !"".equals(left.substring(0, j - 1)) ? Integer.parseInt(left.substring(0, j - 1)) : 1;
                int result = (rightInside + leftInSide) * leftOutSide * rightOutside;
                if (result < min) {
                    min = result;
                    leftParenthesesIndex = j - 1;
                    rightParenthesesIndex = i + 1;
                }
            }
        }
        return String.format("%s(%s+%s)%s", left.substring(0, leftParenthesesIndex), left.substring(leftParenthesesIndex)
                , right.substring(0, rightParenthesesIndex), right.substring(rightParenthesesIndex));

    }


    @Test
    public void test1() {
        Assert.assertEquals("2(47+38)", minimizeResult("247+38"));
        Assert.assertEquals("1(2+3)4", minimizeResult("12+34"));

    }
}