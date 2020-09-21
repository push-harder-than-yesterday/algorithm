package leetcode.week3;

/**
 * created by victory_woo on 2020/09/18
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    static int dfs(TreeNode node, int depth) {
        if (node == null) return depth;

        int leftDepth = dfs(node.left, depth + 1);
        int rightDepth = dfs(node.right, depth + 1);
        int max = Math.max(leftDepth, rightDepth);
        return max;
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
