package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node1;
        node3.next = node4;
        node4.next = node2;

        System.out.println("result: " + hasCycle(node1));
    }

    public static boolean hasCycle(ListNode head) {
        // 첫번째 풀이
        // 자료구조 `Set` 을 이용해 겹치는 객체가 있는 경우 싸이클이라고 판단
        if (head == null || head.next == null) return false;
        Set<ListNode> setData = new HashSet<>();
        ListNode node = head;
        while (true) {
            if (node.next == null) {
                // 연결이 끊기면 싸이클이 아님
                return false;
            }
            if (setData.contains(node)) {
                // HashSet에 이미 데이터가 있으면 싸이클임
                return true;
            }

            setData.add(node);
            node = node.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
