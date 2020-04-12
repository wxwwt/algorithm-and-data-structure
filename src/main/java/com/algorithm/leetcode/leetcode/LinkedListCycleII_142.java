package com.algorithm.leetcode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author scott
 * @date 2020/3/29 22:32
 */

public class LinkedListCycleII_142 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test1() {
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(-7);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(-4);
        ListNode n5 = new ListNode(19);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(-9);
        ListNode n8 = new ListNode(-5);
        ListNode n9 = new ListNode(-5);
        ListNode n10 = new ListNode(-5);

        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n5;

        Assert.assertEquals(19, detectCycle(n1).val);
    }

    @Test
    public void test2() {
        ListNode n1 = new ListNode(1);
        Assert.assertNull(detectCycle(n1));
    }

    @Test
    public void test3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        Assert.assertEquals(1, detectCycle(n1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode currentNode = head;
        Map<ListNode, ListNode> hash = new HashMap<>();
        // 这里有个边界条件就是head可能本来就是空的 要直接返回null
        while (currentNode != null) {
            // 在对链表进行遍历 有出现两次相同 指向节点就是入环的首节点
            // 这里要注意出现两次指的是hash或者说是内存地址 一开始我用的val来判断的出现两次会有问题
            // 因为val的值是可以重复的
            if (hash.containsKey(currentNode)) {
                return currentNode;
            }
            hash.put(currentNode, currentNode);
            currentNode = currentNode.next;
        }
        return null;
    }

    public static void printNode(ListNode node) {
        ListNode currentNode = node;
        while (currentNode.next != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.val);
    }
}