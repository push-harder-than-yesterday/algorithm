package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBinaryTreeFromPreorderandInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        System.out.println("result: " + buildTree(preorder, inorder));
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 빈 공간을 찾아내는게 핵심인 듯..
        // inorder 는 left -> root -> right
        // preorder 는 root -> left -> right
        // left / root 의 차이....
        // 모르겠다.. 규칙을 모르겠다. 솔루션을 참고했다.
        // https://www.techiedelight.com/construct-binary-tree-from-inorder-preorder-traversal/
        // 봐도 잘 모르겠다... 혹시 푸신 분이 있다면 물어봐야겠다..

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // AtomicInteger 는 멀티 쓰레드 환경에서 동기화 문제를 해결한 원자 타입이다.
        // 재귀 함수는 멀티 쓰레드가 아닌데 왜 int 로 preIndex 를 선언하면 IndexOutOfBound 가 발생하지..?
        AtomicInteger preIndex = new AtomicInteger(0);
//        int preIndex = 0;
        return buildTree(0, inorder.length - 1, preorder, preIndex, map);
    }

    private static TreeNode buildTree(int start, int end, int[] preorder, AtomicInteger preIndex, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex.getAndIncrement()]);
//        TreeNode root = new TreeNode(preorder[preIndex]);
//        preIndex++;

        int rootIndex = map.get(root.val);
        root.left = buildTree(start, rootIndex - 1, preorder, preIndex, map);
        root.right = buildTree(rootIndex + 1, end, preorder, preIndex, map);

        return root;
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
