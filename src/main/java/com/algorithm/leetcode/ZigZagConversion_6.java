package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scott
 * @date 2019/10/20 16:44
 */
public class ZigZagConversion_6 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> resultList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            resultList.add(new StringBuilder());
        }
        int listIndex = 0, direction = 1;

        for (int i = 0; i < s.length(); i++) {
            resultList.get(listIndex).append(s.charAt(i));
            if (listIndex == numRows - 1 || (i != 0 && listIndex == 0)) {
                direction *= -1;
            }
            listIndex += direction;
        }

        for (int i = 0; i < resultList.size(); i++) {
            if (i != 0) {
                resultList.get(0).append(resultList.get(i));
            }
        }
        return resultList.get(0).toString();
    }

    public static void main(String[] args) {
        //  System.out.println(convert("LEETCODEISHIRING", 3));
        //   System.out.println(convert("LEETCODEISHIRING", 4));
        System.out.println(convert("ab", 1));
    }
}