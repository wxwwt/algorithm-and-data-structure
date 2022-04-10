package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/4/10 11:51
 */
public class MinimizeResult_6038 {

    public String minimizeResult(String expression) {
      int plusIndex =  expression.indexOf("+");
      String left = expression.substring(0, expression.indexOf("+"));
      String right = expression.substring(plusIndex + 1);
      return "";
    }


    @Test
    public void test1() {
        Assert.assertEquals("", minimizeResult("247+38"));
    }
}