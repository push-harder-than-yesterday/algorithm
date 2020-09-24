package leetcode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(-1); // null
//        TreeNode node5 = new TreeNode(-1); // null
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(6);

        node1.left = node2;
//        node1.right = node3;
//        node3.left = node6;
//        node3.right = node7;

        System.out.println("result: " + isValidBST(node1));
    }

    public static boolean isValidBST(TreeNode root) {
        // 도저히 모르겠어서 답보고 풀었는데도 이해가 안감..
        // 나중에 다시 이해해보고 풀기..
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, double min, double max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        boolean isLeftBST = isValidBST(root.left, min, root.val);
        boolean isRightBST = isValidBST(root.right, root.val, max);

        if (!isLeftBST || !isRightBST) {
            return false;
        }

        return true;
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
