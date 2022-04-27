package com.algorithm.leetcode.leetcode.offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author scott
 * @date 2022/4/27 22:22
 */
public class ReversePrint_06 {

    public int[] reversePrint(ListNode head) {
        int[] arr = new int[10000];
        int count = 0;
        while (head != null) {
            arr[count] = head.val;
            head = head.next;
            count++;
        }
        int[] resultArr = new int[count];
        int length = count;
        for (int j = 0; j < count; j++, length--) {
            resultArr[j] = arr[length - 1];
        }
        return resultArr;
    }

    @Test
    public void test1() {
        Assert.assertTrue(Arrays.equals(new int[]{2, 3, 1}, reversePrint(new ListNode(1, new ListNode(3, new ListNode(2, null))))));
    }
}