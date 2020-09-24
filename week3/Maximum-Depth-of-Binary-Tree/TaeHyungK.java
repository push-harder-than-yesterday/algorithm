package leetcode;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(-1); // null
        TreeNode node5 = new TreeNode(-1); // null
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(17);

        node1.left = node2;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;

        System.out.println("result: " + maxDepth(node1));
    }

    public static int maxDepth(TreeNode root) {
        // 도저히 모르겠어서 답보고 풀었더니 이해가 감..
        // 나중에 다시 또 풀어볼 것
        if (root == null) return 0;

        int depth = 0;
        int leftDepth = 0;
        int rightDepth = 0;

        leftDepth = maxDepth(root.left);
        rightDepth = maxDepth(root.right);
        depth = leftDepth >= rightDepth ? leftDepth + 1 : rightDepth + 1;

        return depth;
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
