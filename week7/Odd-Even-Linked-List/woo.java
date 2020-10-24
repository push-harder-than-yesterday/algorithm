package week7.OddEvenLinkedList;

/**
 * created by victory_woo on 2020/10/22
 */
public class woo {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        oddEvenList(head);
    }

    /*
    * 접근 방법.
    * 앞에서부터 순서를 확인한다.
    * 홀수, 짝수를 구분하여 odd, even 리스트에 추가한다.
    * odd 리스트의 마지막에 even 리스트를 추가한다.
    * */
    public static ListNode oddEvenList(ListNode head) {
        int n = 1;

        ListNode temp = head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode oddPointer = odd, evenPointer = even;
        while (temp != null) {
            if (n % 2 == 0) {
                even.next = new ListNode(temp.val);
                even = even.next;
            } else {
                odd.next = new ListNode(temp.val);
                odd = odd.next;
            }
            temp = temp.next;

            n++;
        }

        evenPointer = evenPointer.next;
        while (evenPointer != null) {
            odd.next = new ListNode(evenPointer.val);
            odd = odd.next;

            evenPointer = evenPointer.next;
        }

        System.out.println(oddPointer.next);

        return oddPointer.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
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
