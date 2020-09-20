package leetcode.week3;

/**
 * created by victory_woo on 2020/09/18
 */
public class ValidBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    static boolean dfs(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;

        int value = root.val;
        if (lower != null && value <= lower) return false;
        if (upper != null && upper <= value) return false;

        if (!dfs(root.right, value, upper)) return false;
        if (!dfs(root.left, lower, value)) return false;

        return true;
    }

    static class TreeNode {
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
