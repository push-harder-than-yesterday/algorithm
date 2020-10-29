package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * inorder traversal = 중위 순회. left node -> root node -> right node 순으로 순회
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println("result: " + inorderTraversal(root));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;

        if (node.left != null) inorderTraversal(node.left, list);
        list.add(node.val);
        if (node.right != null) inorderTraversal(node.right, list);
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
