package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        System.out.println("result: " + mergeTwoLists(null, node6));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode preNode = null;
        LinkedList<ListNode> list = new LinkedList<>();
        if (l1 != null) {
            dummy.next = l2;
            preNode = l1;
            while (true) {
                list.add(preNode);
                if (preNode.next == null) {
                    break;
                }
                preNode = preNode.next;
            }
        }
        if (l2 != null) {
            if (dummy.next == null) dummy.next = l2;
            preNode = l2;
            while (true) {
                list.add(preNode);
                if (preNode.next == null) {
                    break;
                }
                preNode = preNode.next;
            }
        }

        list.sort((o1, o2) -> {
            if (o1.val >= o2.val) {
                return 1;
            } else {
                return -1;
            }
        });

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
