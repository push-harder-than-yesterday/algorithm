package leetcode;

import java.util.Collections;
import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("result: " + reverseList(node1).val);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        if (head == null || head.next == null) return head;
        ListNode preNode = head;
        LinkedList<ListNode> list = new LinkedList();
        while (true) {
            list.add(preNode);
            if (preNode.next == null) {
                break;
            }
            preNode = preNode.next;
        }

        Collections.reverse(list);
        preNode = dummy;
        for (ListNode node : list) {
            preNode.next = node;
            preNode = preNode.next;
        }
        preNode.next = null;

        return dummy.next;
    }

    private static class ListNode {
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
