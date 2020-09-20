package leetcode.week3;

/**
 * created by victory_woo on 2020/09/16
 */
public class MergeToSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(4);
        l1.next = l11;
        l11.next = l111;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l222 = new ListNode(4);
        l2.next = l22;
        l22.next = l222;
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode firstNode = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }

            result = result.next;
        }

        if (l1 == null) result.next = l2;
        else result.next = l1;

        return firstNode.next;
    }

    public static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}