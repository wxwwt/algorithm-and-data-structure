package com.algorithm.leetcode;

/**
 * @author scott
 * @date 2023/5/7 20:21
 */
public class DeleteNode_18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode vNode = new ListNode(Integer.MIN_VALUE);
        vNode.next = head;
        ListNode curNode = vNode;
        while(curNode.next != null) {
            if (curNode.next.val == val) {
                ListNode next = curNode.next.next;
                curNode.next = next;
                break;
            }
           curNode = curNode.next ;
        }
        return curNode.next;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}