package week8.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * created by victory_woo on 2020/10/25
 */
public class woo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;

        inorderTraversal(root);

    }

    static List<Integer> result;

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        result = new ArrayList<>();

        inorder(root);
        System.out.println(result);
        return result;
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }


    public static class TreeNode {
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
