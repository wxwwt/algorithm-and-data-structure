package com.algorithm.leetcode.leetcode;

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

    public static void main(String[] args) {

    }

    public ListNode getFirstMeetNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 两个指针在列表上遍历  相遇就返回这个相遇的节点
        // 没有相遇就是无环
        while (null != slow && null != slow.next) {
            fast = fast.next;
            slow = slow.next.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }


        ListNode meetNode = getFirstMeetNode(head);
        if (null == meetNode) {
            return null;
        }

        // 从头开始同速度一起跑一次 相遇就是入环节点
        ListNode point1 = head;
        ListNode point2 = meetNode;
        while (point1 != point2) {
            point1 = point1.next;
            point2 = point2.next;
        }
        return point2;
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