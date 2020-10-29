package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("result: " + connect(root));
    }

    private static Node connect(Node root) {
        if (root == null) return null;

        // BFS로 돌면서 next 셋팅해주기
        List<List<Integer>> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelQueue = new ArrayList<>();
            int size = queue.size();

            Node preNode = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll(); // 큐에서 노드 꺼내옴

                if (preNode != null) {
                    preNode.next = node;
                }
                levelQueue.add(node.val);

                if (node.left != null) {
                    queue.add(node.left); // 해당 노드에 left가 있으면 큐에 추가
                }
                if (node.right != null) { // 해당 노드에 right가 있으면 큐에 추가
                    queue.add(node.right);
                }
                preNode = node;
            }
            list.add(levelQueue);
        }

        System.out.println(list);


        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
