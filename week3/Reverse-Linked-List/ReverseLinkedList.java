package leetcode.week3;

/**
 * created by victory_woo on 2020/09/16
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode tail = new ListNode(5);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = tail;
        tail.next = null;

        //System.out.println(reverseList(head));
        System.out.println(reverseListWithRecursive(head));
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    private static ListNode reverseListWithRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListWithRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
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
            return "ListNode(" +
                    "val = " + val +
                    ", next = " + next + ')';
        }
    }
}
