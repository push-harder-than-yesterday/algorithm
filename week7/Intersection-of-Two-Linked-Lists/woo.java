package week7.IntersectionofTwoLinkedLists;

import java.util.HashSet;

/**
 * created by victory_woo on 2020/10/22
 */
public class woo {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = new ListNode(8);
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);

        System.out.println(getIntersectionNode(headA, headB));
    }

    /*
     * 첫 번째 방법 - 브루트 포스 O(MN)
     * headA 를 기준으로 잡고 headB 와 일치하는 노드가 있는지 확인한다.
     * 일치하는 게 존재하면 그때의 pointerA 반환.
     * 없다면 Null 반환.
     *
     * */
    /*public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA, pointerB;
        System.out.println(headA);
        System.out.println(headB);

        while (pointerA != null) {
            for (pointerB = headB; pointerB != null; pointerB = pointerB.next) {
                if (pointerA == pointerB) return pointerA;
            }

            *//*while (pointerB != null) {
                if (pointerA == pointerB) return pointerA;

                pointerB = pointerB.next;
            }*//*

            pointerA = pointerA.next;
        }

        return null;
    }*/

    /*
     * 두 번째 접근 방법 - HashTable O(M+N)
     * headA 를 순회하면서 node 를 hashTable 에 추가한다.
     * nodes 가 비어있다면 교차점이 없으니 null 반환.
     *
     * headB 를 순회하면서 nodes 에 저장된 것들 중 일치하는 경우가 있는지 찾는다.
     * 일치하는 경우가 있다면 pb 반환.
     * 없다면 null 반환.
     * */
    /*public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodes = new HashSet<>();

        ListNode pa = headA;
        while (pa != null) {
            nodes.add(pa);
            pa = pa.next;
        }

        System.out.println(nodes);

        if (nodes.isEmpty()) return null;

        ListNode pb = headB;
        while (pb != null) {
            if (nodes.contains(pb)) return pb;

            pb = pb.next;
        }

        return null;
    }*/

    /*
    * 세 번째 접근 방법 - 투포인터 O(M+N)
    * 2개의 포인터를 가지고 만날때까지 동일한 교차노드를 만날때까지 반복
    * 근데, null 인 경우에 왜 headB...?
    * 이해가 잘 안감.
    * */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;

        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }

        return pa;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
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

