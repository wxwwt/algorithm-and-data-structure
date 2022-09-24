package com.algorithm.leetcode.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author scott
 * @date 2022/9/22 22:52
 */
public class StringSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            String temp = in.next();
            list[i] = temp;
        }

//        for (int i = 0; i < list.length; i++) {
//            for (int j = i + 1; j < list.length; j++) {
//                if (list[i].compareTo(list[j]) > 0) {
//                    String temp =  list[i];
//                    list[i] = list[j];
//                    list[j] = temp;
//                }
//            }
//        }

        Arrays.sort(list);


        for (int i = 0; i < n; i++) {
            System.out.println(list[i]);
        }


    }

    @Test
    public void test1() {

    }
}