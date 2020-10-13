package week4.LinkedListCycle;

import java.util.HashSet;

/**
 * created by victory_woo on 2020/09/23
 */
public class woo {
    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        System.out.println(hasCycle(root));
    }


    // 첫번째 접근 : HashTable.

    // 시간 복잡도 : O(N)
    // 공간 복잡도 : O(N)
    /*public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }*/

    // 두번째 접근 : 투포인터.
    private static boolean hasCycle(ListNode head) {
        // head 가 null 이면 구성하는 노드가 없으므로 싸이클이 될 수 없다.
        // head.next 가 널이라면 노드가 하나밖에 없으므로 이 경우에도 싸이클이 될 수 없다.
        if (head == null || head.next == null) return false;

        // 한 단계씩 이동하는 포인터.
        ListNode slow = head;
        // 두 단계씩 이동하는 포인터.
        ListNode fast = head.next;

        // 두 포인터가 만날때까지 반복한다.
        // 싸이클을 이룬다면 만날 수 밖에 없다. 왜냐하면 slow 는 한 단계씩 이동하고
        // fast 는 두 단계씩 이동하기 때문에 결국 만난다.
        while (slow != fast) {
            // 싸이클이 없다면 fast 는 결국 끝에 도달하여 null 을 만나므로 false 반환.
            if (fast == null || fast.next == null) return false;

            // 한 단계씩 이동.
            slow = slow.next;
            // 두 단계씩 이동.
            fast = fast.next.next;
        }

        // 여기까지 오는 경우에는 싸이클을 이루는 것을 뜻한다.
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
