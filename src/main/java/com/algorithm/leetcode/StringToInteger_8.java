package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shenchuang
 * @since 2020-03-31
 */
public class StringToInteger_8 {

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];
        long sum = 0;
        int count = 0;
        int flag = 1;

        // 空字符串返回0
        if (chars.length == 0) {
            return 0;
        }

        for (int i = 0; i < chars.length; i++) {
            // 如果是空格并且没有数字被保存就略过
            if (chars[i] == ' ' && result[0] != 0) {
                continue;
            }

            // 将每个数字提取出来 放入数组
            if (isDigit(chars[i])) {
                // 数字前面还有字符的话 取第一个数字前那个符号 就把前面是 -的符号给保存起来
                // +号就不管了 默认是正数
                if (result[0] == 0 && i - 1 >= 0) {
                    if (chars[i - 1] == '-') {
                        flag = -1;
                    } else if (chars[i - 1] == '+') {
                        flag = 1;
                    } else if (chars[i - 1] != ' ') {
                        return 0;
                    }

                    if (i - 2 >= 0 && chars[i - 2] != ' ') {
                        return 0;
                    }
                }

                result[count] = chars[i];
                ++count;
            } else {
                // 如果数组里面有值了 但是当前字符不是数字就直接返回数组中的数值
                if (result[0] != 0) {
                    break;
                }
            }
        }

        // 数组是空的 就直接返回
        if (result[0] == 0) {
            return 0;
        }
        // 将数组中的值还原为十进制
        int tempCount = count - 1;
        for (int j = 0; j <= count - 1; j++, tempCount--) {
            sum += (result[j] - 48) * (int) Math.pow(10, tempCount);
        }
        // 加上符号
        sum *= flag;

        // 处理最大小值
        if (sum >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (sum <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) sum;
    }

    public boolean isDigit(char temp) {
        if (temp >= 48 && temp <= 57) {
            return true;
        }
        return false;
    }

    @Test
    public void test1() {
        Assert.assertEquals(42, myAtoi("42"));
        Assert.assertEquals(-42, myAtoi("   -42"));
        Assert.assertEquals(0, myAtoi("words and 987"));
        Assert.assertEquals(4193, myAtoi("4193 with words"));
        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));

        Assert.assertEquals(3, myAtoi("3.14159"));
        Assert.assertEquals(0, myAtoi(""));
        Assert.assertEquals(0, myAtoi("+-2"));
        Assert.assertEquals(1, myAtoi("01+-2"));
        Assert.assertEquals(0, myAtoi(".1"));

        Assert.assertEquals(12345678, myAtoi("  0000000000012345678"));
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
