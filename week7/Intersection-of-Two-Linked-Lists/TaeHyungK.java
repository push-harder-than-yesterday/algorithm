package leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 첫번째 풀이
        // 왜 Example1에서 1845가 같은데 답이 1이 아닌지가 이해가 가지 않는다.
        //  -> 자료구조 Set 을 이용해 같은 값이 있는지 체크
        //  -> 아마 노드 객체자체로 비교하도록 되어있나보다. 문제가 너무 부실했던 것 같다.
        Set<ListNode> data = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            data.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (data.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
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

        public static void printNode(ListNode temp) {
            while (temp != null) {
                System.out.print(temp.val + ", ");
                temp = temp.next;

                if (temp == null) System.out.println("NULL");
            }
            System.out.println();
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
