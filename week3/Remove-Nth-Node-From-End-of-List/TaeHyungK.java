package leetcode;

import java.util.LinkedList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        // 1->2->3->4->5
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int n = 2;
        System.out.println("result: " + removeNthFromEnd(node1, n));

        node1.next = null;
        n = 1;
//        ListNode result = removeNthFromEnd(node1, n);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 첫번째 풀이
        // 마지막 노드가 나올 때까지 LinkedList에 추가한다.
        // 이후 사이즈 - n 을 통해 위치를 찾고 삭제한다.
        // 예외 케이스가 많아 모든 대응이 불가하다.. 흠..
//        List<ListNode> linkedList = new LinkedList<>();
//
//        ListNode preNode = head;
//        while (true) {
//            if (preNode.next == null) {
//                linkedList.add(preNode);
//                break;
//            }
//            linkedList.add(preNode.next);
//            preNode = preNode.next;
//        }
//
//        int targetIndex = linkedList.size() - n;
//        System.out.println(linkedList.size() + " | " +  targetIndex + " | " + linkedList.get(targetIndex).val);
//
//        if (linkedList.size() <= 1) return null;
//
//        System.out.println("-------------");
//        preNode = head;
//        int count = 0;
//        while (true) {
//            System.out.println(count + " | " + preNode.val + " | " + preNode.next.val);
//            if (targetIndex - 1 < 0) {
//                preNode.next = null;
//                break;
//            } else if (preNode.next == linkedList.get(targetIndex - 1)) {
//                preNode.next = preNode.next.next;
//                break;
//            }
//            preNode = preNode.next;
//            count++;
//        }
//
//        return head;

        // 두번째 풀이
        // 맨 처음 노드를 반환하기 위해 더미로 맨 앞에 하나 만들어준다.
        // 노드의 총 갯수를 구한 다음, 그 앞에 까지는 그냥 기존 노드처럼 붙여준다.
        // 지워야할 노드순서에서 다음다음의 노드를 붙여버린다.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = head;
        int count = 0;
        while (true) {
            if (preNode.next == null) {
                count++;
                break;
            }
            preNode = preNode.next;
            count++;
        }
        int targetIndex = count - n;
        preNode = dummy;
        while (targetIndex > 0) {
            targetIndex--;
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
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
