package com.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

public class BeautifulTowersII_2866 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        if (maxHeights.size() == 1) {
            return maxHeights.get(0);
        }
        Stack<Integer> stack = new Stack<>();
        int n = maxHeights.size();
        long ans = 0;
        long[] pre = new long[n];
        // 山状数组左边的递增数组 栈顶到栈底是递减的
        for (int i = 0; i < n; i++) {
            // 栈不为空 并且 栈顶元素是大于当前元素就要处理
            while(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                stack.pop();
            }

           if (!stack.isEmpty()) {
               int t = stack.peek();
               pre[i] = pre[t] + (long)(i - t) * maxHeights.get(i) ;
           } else {
               pre[i] = (long)(i + 1) * maxHeights.get(i) ;
           }

            stack.push(i);

        }

        stack.clear();
        long[] surf = new long[n];
        // 山状数组的右边 递减数组 栈顶到栈底是递增的 我们从右往左遍历就可以和pre数组一样的处理方式
        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                 stack.pop();
            }

            if (!stack.isEmpty()) {
                int t = stack.peek();
                surf[i] = surf[t] + (long)(t - i) * maxHeights.get(i) ;
            } else {
                surf[i] = (long)(n - i) * maxHeights.get(i) ;
            }

            stack.push(i);

        }

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, pre[i] + surf[i+1]);
        }
        return ans;
    }


    @Test
    public void test1() {
        Assert.assertEquals(25, maximumSumOfHeights(Lists.newArrayList(6,5,3,4,6,1,2,3,2,5)));
        Assert.assertEquals(1000000000, maximumSumOfHeights(Lists.newArrayList(1000000000)));
        Assert.assertEquals(13, maximumSumOfHeights(Lists.newArrayList(5,3,4,1,1)));
        Assert.assertEquals(22, maximumSumOfHeights(Lists.newArrayList(6,5,3,9,2,7)));
        Assert.assertEquals(18, maximumSumOfHeights(Lists.newArrayList(3,2,5,5,2,3)));
    }
}
