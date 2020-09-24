package week4.PalindromeLinkedList;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/09/23
 */
public class woo {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int len = list.size();
        for (int i = 0; i < len / 2; i++) {
            if (!list.get(i).equals(list.get(len - i - 1))) return false;
        }

        return true;
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
    }
}
