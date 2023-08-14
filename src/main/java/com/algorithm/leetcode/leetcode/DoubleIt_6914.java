package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scott
 * @date 2023/8/13 10:20
 */
public class DoubleIt_6914 {

    public ListNode doubleIt(ListNode head) {

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int pre = 0;
        ListNode newHead = list.get(0);
        for (int i = list.size() - 1 ; i >= 0; i--) {
           ListNode temp =  list.get(i);
           int value = temp.val * 2;
           int mod = value % 10;
            temp.val = mod + pre;
           pre = value / 10;


           if (i == 0 && pre > 0) {
               newHead = new ListNode(pre);
               newHead.next = list.get(0);
           }
        }



        return newHead;
    }


    @Test
    public void test1() {
        Assert.assertEquals(new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(6)))), doubleIt(new ListNode(9, new ListNode(9, new ListNode(8)))));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}