package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author scott
 * @date 2023/7/30 10:08
 */
public class LCP_373_1 {

    public boolean areSimilar(int[][] mat, int k) {

         boolean ans = true;
            int r = mat.length;;
            int c = mat[0].length;
            for (int i = 0 ; i < r ; i++) {
                for(int j = 0; j < c; j++) {
                    if (mat[i][j] != mat[i][(j + k) % c]) {
                            return false;
                    }
                }
            }
            return ans;


    }


    @Test
    public void test1() {
        Assert.assertEquals(true, areSimilar(new int[][]{{9,1,8,9,2,9,1,8,9,2},{10,2,7,8,9,10,2,7,8,9},{7,6,6,9,5,7,6,6,9,5}}, 5));
//        Assert.assertEquals(4, minimumPossibleSum(2,3));
//        Assert.assertEquals(8, minimumPossibleSum(3,3));
//        Assert.assertEquals(1, minimumPossibleSum(1,1));
//        Assert.assertEquals(12, minimumPossibleSum(4,4));
//
//        Assert.assertEquals(2948940321L, minimumPossibleSum(63623,82276));
//        System.out.println(Math.pow(10, 5));
    }
}