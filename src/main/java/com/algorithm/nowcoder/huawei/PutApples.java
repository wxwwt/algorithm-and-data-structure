package com.algorithm.nowcoder.huawei;

import org.junit.Assert;
import org.junit.Test;

/**
 * 牛客网 华为机试 HJ61 放苹果
 * 标签 动态规划
 * @author scott
 * @date 2022/9/12 16:40
 */
public class PutApples {

    /**
     * m表示苹果数量 n表示盘子数量
     * @param m
     * @param n
     * @return
     */
    public static int dp(int m , int n) {
        if (m < 0 || n == 0) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        return dp(m, n-1) + dp(m-n, n);

    }

    @Test
    public void test1() {
        Assert.assertEquals(8, dp(7,3));
    }
}