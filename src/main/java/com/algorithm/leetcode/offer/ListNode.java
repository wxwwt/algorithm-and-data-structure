package com.algorithm.leetcode.offer;

/**
 * @author scott
 * @date 2022/4/27 22:53
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
