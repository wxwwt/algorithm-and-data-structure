package com.algorithm.leetcode.leetcode.offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author scott
 * @date 2022/4/23 23:04
 */
public class CQueue_09 {


    @Test
    public void test1() {
        CQueue obj = new CQueue();
        obj.appendTail(3);
        int result = obj.deleteHead();
        Assert.assertEquals(3, result);
        Assert.assertEquals(-1, obj.deleteHead());
    }

    @Test
    public void test2() {
        CQueue obj = new CQueue();
        Assert.assertEquals(-1, obj.deleteHead());
        obj.appendTail(5);
        obj.appendTail(2);
        Assert.assertEquals(5, obj.deleteHead());
        Assert.assertEquals(2, obj.deleteHead());
    }
}

class CQueue {

    Stack<Integer> positiveStack = new Stack<>();
    Stack<Integer> negativeStack = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        positiveStack.push(value);
    }

    public int deleteHead() {
        // 反向的栈如果有数据就直接弹出
        if (!negativeStack.isEmpty()) {
            return negativeStack.pop();
        } else {
            // 如果正向栈不为空，反向栈为空就把正向栈的数据放入到反向栈里面在弹出
            while (!positiveStack.isEmpty()) {
                negativeStack.push(positiveStack.pop());
            }
            if (negativeStack.isEmpty()) {
                return -1;
            }
            return negativeStack.pop();
        }
    }
}