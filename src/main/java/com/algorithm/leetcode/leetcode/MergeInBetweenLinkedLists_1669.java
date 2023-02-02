package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/1/31 23:14
 */
public class MergeInBetweenLinkedLists_1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode startNode = list1;
        ListNode curNode = list1;
        ListNode leftNode = null;
        ListNode rightNode = null;
        while(curNode != null) {
            if (curNode.next != null && curNode.next.val  == a) {
                leftNode = curNode;
            }

            if (curNode.val == b) {
                rightNode = curNode.next;
            }

            curNode = curNode.next;
        }

        ListNode midNode = null;
        curNode = list2;
        while (curNode != null) {
            if (curNode.next == null) {
                midNode = curNode;
                break;
            }
            curNode = curNode.next;
        }

        leftNode.next = list2;
        midNode.next = rightNode;
        return startNode;
    }

    @Test
    public void test1() {
        Assert.assertEquals(new ListNode(0,new ListNode(1,new ListNode(2, new ListNode(1000000, new ListNode(1000001, new ListNode(1000002, new ListNode(5))))))),
                mergeInBetween(new ListNode(0,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))))),
                        3,4, new ListNode(1000000,new ListNode(1000001,new ListNode(1000002)))));
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