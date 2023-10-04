package com.algorithm.leetcode;

/**
 * @author shenchuang
 * @since 2020-03-28
 */
public class RemoveLinkedListNode_19 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        printNode(removeLinkedListNode(n1, 5));

        ListNode n1 = new ListNode(1);
        System.out.println(removeLinkedListNode(n1, 1));
    }

    /**
     * 第一种解法 之遍历了一次 但是把每个节点都存了一次  性能很不好
     * 分三种情况分别讨论的
     */
 /*   public static ListNode removeLinkedListNode(ListNode head, int n) {
        ListNode currentNode = head;
        if (head.next == null && n == 1) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        while (currentNode.next != null) {
            listNodes.add(currentNode);
            currentNode = currentNode.next;
        }
        listNodes.add(currentNode);
        int size = listNodes.size();
        if (listNodes.size() == n) {
            // 如果是第一个数被移除  直接返回第一个节点的next
            return head.next;
        } else if (1 == n) {
            // 如果是最后一个元素被移除 将倒数第二个元素的指针置为null
            listNodes.get(size - 2).next = null;
            return head;
        } else {
            // 中间节点被移除 就将n - 1 指向n + 1
            ListNode subNode = listNodes.get(size - n - 1);
            ListNode plusNode = listNodes.get(size - n + 1);
            subNode.next = plusNode;
            return head;
        }
    }*/

    /**
     * 优化的方法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeLinkedListNode(ListNode head, int n) {
        ListNode virtualNode = new ListNode(0);
        virtualNode.next = head;
        ListNode fastPoint = virtualNode;
        ListNode slowPoint = virtualNode;
        int count = 0;
        while (fastPoint != null) {
            // 先将快指针移动n个位置 因为是有虚拟节点所以要多移动一次是<=n
            if (count <= n) {
                fastPoint = fastPoint.next;
                ++count;
            } else {
                fastPoint = fastPoint.next;
                slowPoint = slowPoint.next;
            }

        }
        // 将慢指针的指向后一个节点
        slowPoint.next = slowPoint.next.next;
        return virtualNode.next;
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
