package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

public class LCP_364_4 {


    public long countPaths(int n, int[][] edges) {
        int size = edges.length;
        long count = 0;
        for (int i = 0; i < size; i++) {
            if (isPrime(edges[i][0]) && !isPrime(edges[i][1])) {
                count++;
            } else if (!isPrime(edges[i][0]) & isPrime(edges[i][1])) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(long n) {
        if (n <= 3) {
            return n > 1;
        }

        long sqrt = (long) Math.sqrt(n);
        for (long i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;


    }


    @Test
  public void test1() {
        Assert.assertEquals(4, countPaths(5, new int[][]{{1,2}, {1,3}, {2,4},{2,5}}));
  }
}
