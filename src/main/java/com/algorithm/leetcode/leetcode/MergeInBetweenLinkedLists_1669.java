package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott
 * @date 2023/1/31 23:14
 */
public class MergeInBetweenLinkedLists_1669 {

    /**
     * 解法一：分别遍历list1，list2，
     * 从list1里面找到a的前一个节点，b的后一个节点，用指针存起来
     * 从list2里面找到一个list2节点，找到最后一个节点
     * 最后把四个节点连起来
     * 时间复杂度：O(m+n)
     * 空间复杂度：常数级 o(1)
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween1(ListNode list1, int a, int b, ListNode list2) {
        ListNode curNode = list1;
        ListNode leftNode = null;
        ListNode rightNode = null;
        for (int i = 0; curNode != null; curNode = curNode.next, i++) {
            if (curNode.next != null && i + 1 == a) {
                leftNode = curNode;
            }

            if (i == b) {
                rightNode = curNode.next;
            }

        }

        curNode = list2;
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        leftNode.next = list2;
        curNode.next = rightNode;
        return list1;
    }

    /**
     * 官网标准解法
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = list1;
        for (int i = 0; i < a - 1; i++) {
            preA = preA.next;
        }
        ListNode preB = preA;
        for (int i = 0; i < b - a + 2; i++) {
            preB = preB.next;
        }
        preA.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = preB;
        return list1;
    }


    @Test
    public void test1() {
        Assert.assertEquals(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(1000000, new ListNode(1000001, new ListNode(1000002, new ListNode(5))))))),
                mergeInBetween2(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
                        3, 4, new ListNode(1000000, new ListNode(1000001, new ListNode(1000002)))));
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