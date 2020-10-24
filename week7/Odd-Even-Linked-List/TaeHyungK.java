package leetcode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
//        ListNode l1_7 = new ListNode(9);
//        ListNode l1_6 = new ListNode(9, l1_7);
        ListNode l1_5 = new ListNode(5, null);
        ListNode l1_4 = new ListNode(4, l1_5);
        ListNode l1_3 = new ListNode(3, l1_4);
        ListNode l1_2 = new ListNode(2, l1_3);
        ListNode head = new ListNode(1, l1_2);

        ListNode.printNode(head);

        ListNode.printNode(oddEvenList(head));
    }

    private static ListNode oddEvenList(ListNode head) {
        // 첫번째 풀이
        // oddNode 와 evenNode를 뽑아낸 후
        // 각 노드들을 resultNode로 합친다.
        ListNode oddNode = new ListNode();
        ListNode evenNode = new ListNode();

        ListNode temp = head;
        ListNode oddTemp = oddNode;
        ListNode evenTemp = evenNode;
        int index = 0;
        while (temp != null) {
            if (index % 2 != 0) {
                oddTemp.next = new ListNode(temp.val);
                oddTemp = oddTemp.next;
            } else {
                evenTemp.next = new ListNode(temp.val);
                evenTemp = evenTemp.next;
            }

            temp = temp.next;
            index++;
        }

        ListNode resultNode = new ListNode();
        ListNode resultTemp = resultNode;

        temp = evenNode.next;
        while (temp != null) {
            resultTemp.next = new ListNode(temp.val);
            resultTemp = resultTemp.next;

            temp = temp.next;
        }
        temp = oddNode.next;
        while (temp != null) {
            resultTemp.next = new ListNode(temp.val);
            resultTemp = resultTemp.next;

            temp = temp.next;
        }

        return resultNode.next;
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
