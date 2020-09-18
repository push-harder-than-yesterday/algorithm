package leetcode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(-1); // null
        TreeNode node5 = new TreeNode(-1); // null
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;

        System.out.println("result: " + levelOrder(node1).toString());
    }

    private static List<List<Integer>> list = new ArrayList<>();
    private static int count = 0;

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 첫번째 풀이 전역변수를 이용해서 풀어보자.
        // 릿코드 내부적으로 테스트 케이스를 돌 때 새로 돌리는 게 아닌 것 같다.
        // 전역변수를 쓰면 해당 전역변수가 초기화 되지 않아 불가능하다.
//        if (root == null) return list;
//        if (root.left == null && root.right == null) return list;
//
//        if (count == 0) {
//            List<Integer> first = new ArrayList<>();
//            first.add(root.val);
//            count++;
//            list.add(first);
//        }
//        List<Integer> level = new ArrayList<>();
//        if (root.left != null) level.add(root.left.val);
//        if (root.right != null) level.add(root.right.val);
//        if (!level.isEmpty()) list.add(level);
//
//        levelOrder(root.left);
//        levelOrder(root.right);
//
//        return list;

        // 두번째 풀이
        // BFS 하는 방법 검색 후 적용해보자.
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
