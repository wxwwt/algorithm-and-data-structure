package com.algorithm.completition;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCP_364_3 {

//    public long maximumSumOfHeights(List<Integer> maxHeights) {
//        Stack<Integer> stack = new Stack<>();
//        int n = maxHeights.size();
//        long ans = 0;
//        long[] surf = new long[n];
//        for (int i = n -1 ; i >= 0; i--) {
//            // 从右往前遍历 是升序
//            int cur = maxHeights.get(i);
//            int topIndex = stack.peek();
//            while(!stack.isEmpty() && cur < maxHeights.get(topIndex)) {
//                stack.pop();
//            }
//            // 举例 3 4 2 1 下标是 0 1 2 3 cur 是3， stack.peek是2
//            // 当前值等于 3 加上 下标（2-0）* 2 + 2右边算过的后缀和 1
//            surf[i] = cur + (topIndex - i) * maxHeights.get(topIndex) +  surf[topIndex + 1];
//            stack.push(i);
//        }
//
//
//        for (int i = 0; i < n - 1; i++) {
//            // 从左往右遍历是升序
//        }
//
//    }

//    public long maximumSumOfHeights(List<Integer> maxHeights) {
//        long n = maxHeights.size();
//        long res = 0;
//        long maxN = maxHeights.get(0);
//        List<Integer> maxIndexList = new ArrayList<>();
//        long maxSameLength = 1;
//        int sameIndex = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            int t = maxHeights.get(i);
//            int sum = 0;
//            while (!stack.isEmpty() && t < stack.peek() ) {
//                int pop = stack.pop();
//                sum -= pop;
//            }
//            stack.push(t);
//            sum += t;
//        }
//
//
//        res = Math.max(cal(maxHeights, sameIndex), res);
//        return res;
//    }


    public long cal(List<Integer> maxHeights, int i) {
        long n = maxHeights.size();
        long count = maxHeights.get(i);
        long l = maxHeights.get(i);
        for (int j = i - 1; j >= 0; j--) {
            if (maxHeights.get(j) > l) {
                count += l;
            } else {
                count += maxHeights.get(j);
                l = maxHeights.get(j);
            }
        }

        long r = maxHeights.get(i);
        for (int z = i + 1; z < n; z++) {

            if (maxHeights.get(z) > r) {
                count += r;
            } else {
                count += maxHeights.get(z);
                r = maxHeights.get(z);
            }
        }
        return count;
    }

    @Test
    public void test1() {
//        Assert.assertEquals(3000000000L, maximumSumOfHeights(List.of(1000000000, 1000000000, 1000000000)));
//        Assert.assertEquals(13, maximumSumOfHeights(List.of(5, 3, 4, 1, 1)));
//        Assert.assertEquals(22, maximumSumOfHeights(List.of(6, 5, 3, 9, 2, 7)));
//
//        Assert.assertEquals(18, maximumSumOfHeights(List.of(3, 2, 5, 5, 2, 3)));
//        Assert.assertEquals(20, maximumSumOfHeights(List.of(3, 1, 3, 2, 6, 1, 4, 4, 6)));


    }
}
