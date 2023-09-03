package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/9/1 8:02
 */
public class WaysToBuyPensPencils_2240 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long count = 0;
        long n1 = total / cost1;
        long n2 = total / cost2;




        if (n1 < n2) {
            for (long i = 0; i <= n1; i++) {
                long tempToatal = total - i * cost1;
                long tempCount = tempToatal / cost2;
                tempCount = tempCount > 0 ? tempCount + 1: 1;
                count +=  tempCount ;
            }
        } else {
            for (long i = 0; i <= n2; i++) {
                long tempToatal = total - i * cost2;
                long tempCount = tempToatal / cost1;
                tempCount = tempCount > 0 ? tempCount + 1: 1;
                count +=  tempCount ;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        Assert.assertEquals(9, waysToBuyPensPencils(20,10,5));
        Assert.assertEquals(1, waysToBuyPensPencils(5,10,10));
    }
}