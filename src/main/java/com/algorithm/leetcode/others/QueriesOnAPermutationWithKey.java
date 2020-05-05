package com.algorithm.leetcode.others;

import java.util.Arrays;

/**
 * @author scott
 * @date 2020/4/12 11:14
 */
public class QueriesOnAPermutationWithKey {

    public int[] processQueries(int[] queries, int m) {
        int[] P = new int[m];
        int[] position = new int[queries.length];
        for (int i = 0; i < m; i++) {
            P[i] = i + 1;
        }

        // 循环数组找出每个整数的位置
        int lastTemp = 0;
        for (int i = 0; i <= queries.length - 1; i++) {
            for (int j = 0; j <= P.length - 1; j++) {
                if (queries[i] == P[j]) {
                    position[i] = P[j] > lastTemp ? j : j + 1;
                    lastTemp = queries[i] > lastTemp ? queries[i] : lastTemp;
                    break;
                }
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] temp = {3, 1, 2, 1};
        int m = 5;
        int[] test = new QueriesOnAPermutationWithKey().processQueries(temp, m);
        System.out.println(Arrays.toString(test));
    }
}