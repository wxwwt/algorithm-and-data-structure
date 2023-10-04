package com.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scott
 * @date 2022/4/10 10:32
 */
public class LargestNumberAfterDigitSwapsByParity_6037 {

    public int largestInteger(int num) {
        int remainder = 0;
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            remainder = num % 10;
            num = num / 10;
            list.add(remainder);
        }


        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = i -1 ; j >= 0; j--) {
                if ((list.get(i) & 1) == 1 && ((list.get(j) & 1) == 1) && list.get(j) > list.get(i)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);

                }

                if ((list.get(i) & 1) == 0 && ((list.get(j) & 1) == 0) && list.get(j) > list.get(i)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }

        }


        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i) * Math.pow(10, i);
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(664, largestInteger(466));
        Assert.assertEquals(400, largestInteger(400));
        Assert.assertEquals(321, largestInteger(123));
        Assert.assertEquals(1, largestInteger(1));
        Assert.assertEquals(3412, largestInteger(1234));
    }
}