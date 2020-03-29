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
        RemoveLinkedListNode_19.ListNode n1 = new RemoveLinkedListNode_19.ListNode(1);
      //  System.out.println(detectCycle(n1));
    }


    public ListNode detectCycle(ListNode head) {
        // 先设置一个虚拟节点
        ListNode virtualNode = new ListNode(-12345);
        virtualNode.next = head;
        ListNode currentNode = virtualNode;
        Map<Integer, ListNode> hash = new HashMap<>();
//        while(hash.containsKey(currentNode.next)) {
//
//        }
        // 在对链表进行遍历 有出现两次相同 指向节点就是入环的首节点
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