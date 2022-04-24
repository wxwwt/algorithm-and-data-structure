package com.algorithm.leetcode.leetcode.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/4/24 21:36
 */
public class Offer_30 {

    @Test
    public void test1() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        Assert.assertEquals(-3, minStack.min());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.min());


    }

    @Test
    public void test2() {

        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);

        minStack.pop();
        minStack.pop();
        minStack.pop();

        minStack.push(2147483647);
        minStack.push(-2147483648);
        minStack.pop();

        Assert.assertEquals(2147483647, minStack.min());
    }

    @Test
    public void test3() {

        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        minStack.push(-20);

        minStack.pop();

        minStack.push(10);
        minStack.push(-7);
        minStack.push(-7);

        minStack.pop();
        minStack.pop();

        Assert.assertEquals(-10, minStack.min());
    }
}

class MinStack {


    /**
     * 思路是使用两个数组，一个用来实现栈，另外一个用来存储当前站内对应的最小值。
     * 实现栈的数组用head和tail两个指针来标识栈底tail和栈顶head，minArr的下标对应
     * 的是当前stack有几个元素，值就是当前的最小值，比如1,2,3一共三个元素，就是minArr[3] = 1。
     * 当元素被pop时，比如pop掉3，那么当前就剩下两个元素，在添加一个元素a，最小值就是Math.min(a, minArr[元素的数量])
     */
    private int min = 0;
    private int[] stack = new int[20000];
    private int head = -1;
    private int tail = -1;
    private int[] minArr = new int[20000];

    public MinStack() {

    }

    public void push(int x) {
        stack[++tail] = x;
        if (tail == 0) {
            min = x;
        } else {
            min = Math.min(x, minArr[tail - head -1]);
        }
        minArr[tail - head] = min;
    }

    public void pop() {
        tail--;
    }

    public int top() {
        if (head == tail) {
            return -1;
        }
        return stack[tail];
    }

    public int min() {
        if (tail == head) {
            return -1;
        }
        return minArr[tail - head];
    }
}