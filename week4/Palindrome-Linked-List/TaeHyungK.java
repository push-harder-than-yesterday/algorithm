package leetcode;

import java.util.Collections;
import java.util.LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(1);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        System.out.println("result: " + isPalindrome(null));
    }

    public static boolean isPalindrome(ListNode head) {
        boolean result = true;

        // 첫번째 풀이
        // 전체 길이를 구한 후 절반으로 나눠 앞 뒤가 같은지 체크
//        int count = 0;
//        ListNode node = head;
//        // 노드 전체 길이 구하기
//        while (true) {
//            if (node.next == null) {
//                count++;
//                break;
//            }
//            count++;
//            node = node.next;
//        }
//
//        System.out.println(count);
//
//        // 노드 중간 위치 찾기
//        ListNode midNode = head;
//        int midIndex = count / 2;
//        for (int i = 0; i < midIndex; i++) {
//            midNode = midNode.next;
//        }
//
//        // 중간 노드를 거꾸로 넣어야 한다 흠.... 차라리 LinkedList를 쓰자.
//        while (true) {
//
//        }

        // 두번째 풀이
        // LinkedList로 만든 후 팰린드롬 체크
        if (head == null || head.next == null) return true;

        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode node = head;
        while (true) {
            linkedList.add(node);
            if (node.next == null) {
                break;
            }

            node = node.next;
        }

        int left = 0;
        int right = linkedList.size() - 1;
        while (left < right) {
            ListNode leftNode =  linkedList.get(left);
            ListNode rightNode = linkedList.get(right);

            if (leftNode.val != rightNode.val) {
                return false;
            }

            left++;
            right--;
        }

        return result;
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
