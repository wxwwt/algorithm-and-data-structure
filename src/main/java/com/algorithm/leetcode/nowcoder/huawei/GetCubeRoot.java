package com.algorithm.leetcode.nowcoder.huawei;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

/**
 * 求开方根的题目 HJ107 求解立方根
 * 可以使用牛顿迭代法和二分查找
 * 因为不会推导牛顿迭代法的公式，所以选择了二分查找。
 *
 * @author scott
 * @date 2022/9/11 22:10
 */
public class GetCubeRoot {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new  Scanner(System.in);
        Double n = scanner.nextDouble();

        System.out.printf("%.1f", getCubeRoot(n));

    }

    public static String getCubeRoot(Double num) {

        double temp = num;
        boolean positive = true;
        if (num < 0) {
            positive = false;
            temp = -num;
        }

        double max = 0;
        // 要注意的点就是这里 最开始我是使用num作为max 0作为min来计算mid
        // 这样会有问题就是比如计算 0.7的开方根 其实结果是0.8 开方根比原值还大的情况就会死循环一直计算下去
        // 所以要先确定max的大致位置在哪里
        while(max * max * max < temp) {
            max++;
        }


        double min = 0D;
        double mid =  (max + min) / 2;

        double mul = mid * mid * mid;

        while (Math.abs(mul - temp) > 0.001D) {

            if (mul > temp) {
                max = mid;
            } else if (mul < temp) {
                min = mid;
            } else {
                return String.format("%.1f", mid);
            }
            mid = (max + min) / 2;
            mul = mid * mid * mid;
        }
        max = positive ? max : -max;
        return String.format("%.1f", max);
    }

    @Test
    public void test1() {
        Assert.assertEquals(  "-1.7", getCubeRoot( -5D));
        Assert.assertEquals(  "2.7", getCubeRoot( 19.9D));
//        System.out.println(getCubeRoot(0.7));

    }
}