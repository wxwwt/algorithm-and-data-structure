package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author shenchuang
 * @since 2019-10-06
 */
public class Candy_135 {

    public static int getSweet(int[] array) {
        int num = 0;
        for (int i = 0; i < array.length - 1; i++) {
            // 相邻的只要有大于关系 糖果数就得加一
            if (array[i] != array[i + 1]) {
                num += 1;
            }
            // 去除对称的情况
            if (i > 0 && (array[i] > array[i + 1] && array[i] > array[i - 1])) {
                num -= 1;
            }
        }
        return num + array.length;
    }

    public static int candy(int[] ratings) {
        int[] sumArr = new int[ratings.length];
        int sum = 0;
        sumArr[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            // 从左到右 右大于左 并且糖果数就加一
            if (ratings[i] > ratings[i - 1]) {
                sumArr[i] = sumArr[i - 1] + 1;
            } else {
                sumArr[i] = 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            // 从右到做 左大于右 并且糖果数左边小于右边 就加一
            if (ratings[i - 1] > ratings[i] && sumArr[i - 1] <= sumArr[i]) {
                sumArr[i - 1] = sumArr[i] + 1;
            }
        }
        for (int item : sumArr) {
            sum += item;
        }
        return sum;
    }

    public static void main(String[] args) {
      //  System.out.println(candy(new int[]{1, 0, 2}));
     //   System.out.println(candy(new int[]{1, 2, 2}));
        System.out.println(candy(new int[]{1, 3, 4, 5, 2}));

    }

}
