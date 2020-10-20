package leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1_7 = new ListNode(9);
        ListNode l1_6 = new ListNode(9, l1_7);
        ListNode l1_5 = new ListNode(9, l1_6);
        ListNode l1_4 = new ListNode(9, l1_5);
        ListNode l1_3 = new ListNode(9, l1_4);
        ListNode l1_2 = new ListNode(9, l1_3);
        ListNode l1 = new ListNode(9, l1_2);

        ListNode l2_4 = new ListNode(9);
        ListNode l2_3 = new ListNode(9, l2_4);
        ListNode l2_2 = new ListNode(9, l2_3);
        ListNode l2 = new ListNode(9, l2_2);

        ListNode.printNode(l1);
        ListNode.printNode(l2);

        ListNode.printNode(addTwoNumbers(l1, l2));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        // 첫번째 풀이
        // l1, l2 의 max size를 구한 후 그만큼 반복문을 돌며 두 값을 더한다.
        // 마지막에 자릿수가 올라가는 경우 반복문이 종료된 후 자릿수 1을 올려준다.
        int maxSize = Math.max(getSize(l1), getSize(l2));
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        ListNode temp = result;
        boolean isUpper = false;

        for (int i = 0; i < maxSize; i++) {
            int l1Val = l1Temp == null ? 0 : l1Temp.val;
            int l2Val = l2Temp == null ? 0 : l2Temp.val;

            int sum = l1Val + l2Val + (isUpper ? 1 : 0);
            isUpper = sum >= 10;

            temp.next = new ListNode(isUpper ? sum - 10 : sum);
            temp = temp.next;

            l1Temp = l1Temp == null ? null : l1Temp.next;
            l2Temp = l2Temp == null ? null : l2Temp.next;
        }

        if (isUpper) {
            temp.next = new ListNode(1);
        }

        return result.next;
    }

    private static int getSize(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
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
