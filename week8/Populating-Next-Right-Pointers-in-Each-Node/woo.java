package week8.PopulatingNextRightPointersinEachNode;

/**
 * created by victory_woo on 2020/10/26
 */
public class woo {
    public static void main(String[] args) {
        Node left = new Node(2);
        Node leftLeftChild = new Node(4);
        Node leftRightChild = new Node(5);
        left.left = leftLeftChild;
        left.right = leftRightChild;

        Node right = new Node(3);
        Node rightLeftChild = new Node(6);
        Node rightRightChild = new Node(7);
        right.left = rightLeftChild;
        right.right = rightRightChild;

        Node root = new Node(1);
        root.left = left;
        root.right = right;

        System.out.println(connect(root));
    }

    /*
     * 첫 번째 접근 방법.
     * root != null 반복문을 돌았지만, left, right 를 처리하지 못함..
     * */
    /*public static Node connect(Node root) {
        Node dummy = root;
        int count = 1;
        int limit = 1;
        while (dummy != null) {
            if (count == limit) {
                dummy.next = new Node(-1);
                limit = limit * 2;
                count = 1;
            } else {
                count++;
            }

            dummy = dummy.next;
        }

        System.out.println(root);

        return null;
    }*/

    /*
     * 두 번째 접근 방법.
     * 문제를 잘못 이해했다..
     * level 별로 마지막 노드만을 끝에 #과 연결하는 것으로 이해했다..
     * */
    /*public static Node connect(Node root) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            Node pre = q.remove();
            for (int i = 1; i < size; i++) {
                Node cur = q.remove(0);

                if (i == size - 1) {
                    //cur.next = new Node(-1);
                } else {
                    pre.next = cur;
                    pre = cur;
                }

                if (cur.next != null) System.out.print(cur.val + " " + cur.next.val + " ");

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }

            System.out.println();
        }

        return root;
    }*/

    /*
     * 세 번째 접근 방법.
     * 완전 이진 트리이기 때문에 자식 노드는 무조건 2개가 존재한다. 따라서 root.left를 기준으로 하여 한칸씩 타고 내려가면서 확인을 한다.
     * 현재 노드의 left, right에 접근하여 cur.left.next = cur.right로 설정해준다.
     * 그리고 같은 level에 다른 node가 존재한다면 cur.right.next = cur.next.left로 연결해준다.
     * 위와 같은 과정을 트리의 끝까지 반복하여 준다.
     * 이대로 root를 반환하면 마지막 level의 노드에 대한 결과만을 담고 있기 때문에 위에서 선언했던 root에 대한 포인터 head를 반환한다.
     * */
    public static Node connect(Node root) {
        if (root == null) return null;

        Node head = root;
        while (root.left != null) {
            Node cur = root;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }

        return head;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
