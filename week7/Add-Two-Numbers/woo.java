package week7.AddTwoNumbers;

/**
 * created by victory_woo on 2020/10/22
 */
public class woo {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        /*System.out.println(addTwoNumbers(l1, l2));
        System.out.println(addTwoNumbers(new ListNode(0), new ListNode(0)));*/

        ListNode l11 = new ListNode(9);
        ListNode l22 = new ListNode(1);
        l22.next = new ListNode(9);
        l22.next.next = new ListNode(9);
        l22.next.next.next = new ListNode(9);
        l22.next.next.next.next = new ListNode(9);
        l22.next.next.next.next.next = new ListNode(9);
        l22.next.next.next.next.next.next = new ListNode(9);
        l22.next.next.next.next.next.next.next = new ListNode(9);
        l22.next.next.next.next.next.next.next.next = new ListNode(9);
        l22.next.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(l11, l22));
    }

    /*
     * 첫 번째 접근 방법
     * 각각의 LinkedList 로부터 합을 구한 뒤,
     * 최종 sum 을 구하여 LinkedList 를 만들어 반환.
     * int 최대인 21억을 넘어서 90억이 나오기 때문에 long 으로 처리하면 답일 거라 생각했지만
     * 캐리를 고려하지 않아서 오답이 나오는 것을 알았다.
     * */
    /*public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum1 = getSum(l1);
        long sum2 = getSum(l2);

        System.out.println(sum1 + ", " + sum2);

        long sum = sum1 + sum2;
        System.out.println(sum);
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while (sum != 0) {
            long remain = sum % 10;
            sum = sum / 10;

            dummy.next = new ListNode((int) remain);
            dummy = dummy.next;
        }

        if (result.next == null) return new ListNode(0);

        return result.next;
    }

    private static long getSum(ListNode listNode) {
        long sum = 0;
        long n = 0;
        while (listNode != null) {
            sum = sum + listNode.val * (int) Math.pow(10, n);
            listNode = listNode.next;
            n++;
        }

        return sum;
    }*/

    /*
     * 두 번째 접근방법
     * 합을 먼저 구해서 결과를 만들었던 첫 번째 방법이 아니라
     * 두 리스트에 접근해서 합을 구하고 바로 결과 리스트를 만든다.
     * 여기서 주의할 점은 carry 이다.
     * 5+7=12에서 2가 현재 노드에 추가될 값이 되고, 1이 다음 합에 계산될 carry 가 된다.
     * 이러한 점을 주의해서 carry 를 업데이트하고 cur.next 에 추가될 노드는 cur 만 더해주어야 한다.
     * */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = l1, q = l2, cur = dummy;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (0 < carry) cur.next = new ListNode(carry);

        return dummy.next;
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
