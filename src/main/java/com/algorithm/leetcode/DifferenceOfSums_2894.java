package com.algorithm.leetcode;

public class DifferenceOfSums_2894 {

    public int differenceOfSums(int n, int m) {
        int a , b = 0 , c =0;
        for (int i = 1; i < n; i++) {
            c += i;
            if (i % m == 0) {
                b += i;
            }
        }
        a = c - b;
        return a - b;
    }


}
