package com.algorithm.leetcode.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scott
 * @date 2022/6/1 23:04
 */
public class CopyRandomList_35 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curNode = head;
        List<Node> list = new ArrayList<>();
        Map<Node, Node> nodeMap = new HashMap<>();
        while (curNode != null) {

            Node newNode = new Node(curNode.val);
            list.add(newNode);
            nodeMap.put(curNode, newNode);
            curNode = curNode.next;

        }

        curNode = head;
        for (int i = 0; i < list.size(); i++) {
            Node temp = list.get(i);
            temp.next = nodeMap.getOrDefault(curNode.next, null);
            temp.random = nodeMap.getOrDefault(curNode.random, null);
            curNode = curNode.next;
        }
        return list.get(0);
    }

    @Test
    public void test1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.next = null;
        node2.random = node2;
        System.out.println(copyRandomList(node1));
    }


}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}