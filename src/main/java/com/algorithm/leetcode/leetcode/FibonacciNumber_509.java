package com.algorithm.leetcode.leetcode;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author scott
 * @date 2023/2/5 10:45
 */
public class FibonacciNumber_509 {

    public int fib(int n) {
        Map<Integer, Integer> map = Maps.newHashMap();
        if (n == 1 || n == 0) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int temp = fib(n-1) + fib(n-2);
            map.put(n, temp);
            return temp;
        }

    }
}