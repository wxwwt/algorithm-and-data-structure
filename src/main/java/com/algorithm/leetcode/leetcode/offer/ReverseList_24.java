package com.algorithm.leetcode.leetcode.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2022/4/27 22:44
 */
public class ReverseList_24 {

    public ListNode reverseList(ListNode head) {
        ListNode left = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = left;
            left = temp;
        }
        return left;
    }

   /* @Test
    public void test1() {
        Assert.assertEquals(
                new ListNode(5,
                        new ListNode(4,
                                new ListNode(3,
                                        new ListNode(2,
                                                new ListNode(1, null))))),
                reverseList(new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null)))))));
    }*/
}