package leetcode.week3;

/**
 * created by victory_woo on 2020/09/18
 */
public class RemoveNthNode {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        root.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        System.out.println(removeNthFromEnd(root, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = head;
        int count = 0;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }

        int len = count - n;
        pointer = dummy;
        while (len-- > 0) {
            pointer = pointer.next;
        }

        pointer.next = pointer.next.next;
        return dummy.next;
    }

    static class ListNode {
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
