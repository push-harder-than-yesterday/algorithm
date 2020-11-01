package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println("result: " + kthSmallest(root, 3));
    }

    private static int kthSmallest(TreeNode root, int k) {
        // 첫번째 풀이
        // inorder 로 list를 만든 후 k - 1 번째 값을 반환.
        List<Integer> list = new ArrayList<>();
        makeList(root, list);

        return list.get(k - 1);
    }

    private static void makeList(TreeNode node, List<Integer> list) {
        if (node == null) return;

        if (node.left != null) makeList(node.left, list);
        list.add(node.val);
        if (node.right != null) makeList(node.right, list);
    }

    private static List<List<Integer>> getList(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelQueue = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // 큐에서 노드 꺼내옴
                levelQueue.add(node.val); // 꺼내온 노드의 값을 저장

                if (node.left != null) {
                    queue.add(node.left); // 해당 노드에 left가 있으면 큐에 추가
                }
                if (node.right != null) { // 해당 노드에 right가 있으면 큐에 추가
                    queue.add(node.right);
                }
            }
            result.add(levelQueue);
        }

        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
