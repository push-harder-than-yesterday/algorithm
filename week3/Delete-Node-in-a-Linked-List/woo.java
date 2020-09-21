package leetcode.week3;

/**
 * created by victory_woo on 2020/09/18
 */
public class DeleteNodeInaLinkedList {
    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(9);
        root.next = two;
        two.next = three;
        three.next = four;


        Solution solution = new Solution();
        solution.deleteNode(three);
        System.out.println(root);
    }


    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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
