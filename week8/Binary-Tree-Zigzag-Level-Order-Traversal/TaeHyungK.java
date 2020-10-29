package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.left.left = null;
//        root.left.right = null;
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println("result: " + zigzagLevelOrder(root));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // BFS로 풀면 될 듯 함
        // BinaryTreeLevelOrderTraversal 에서 적용한 BFS 참고.
        // 단 levelQueue 에서 리버스로 해야되는 애를 체크해서 거꾸로 넣어줌.
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean needReverse = false;
        while (!queue.isEmpty()) {
            List<Integer> levelQueue = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // 큐에서 노드 꺼내옴

                System.out.println(node.val + " | " + (node.left != null ? node.left.val : "null") + " | " + (node.right != null ? node.right.val : "null"));
                levelQueue.add(needReverse ? 0 : levelQueue.size(), node.val);

                if (node.left != null) {
                    queue.add(node.left); // 해당 노드에 left가 있으면 큐에 추가
                }
                if (node.right != null) { // 해당 노드에 right가 있으면 큐에 추가
                    queue.add(node.right);
                }
            }
            needReverse = !needReverse;
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
