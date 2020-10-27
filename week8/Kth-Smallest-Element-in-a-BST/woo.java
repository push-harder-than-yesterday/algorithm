package week8.KthSmallestElementinaBST;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/10/27
 */
public class woo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = null;
        root.left.right = new TreeNode(2);

        System.out.println(kthSmallest(root, 1));
    }

    /*
     * 첫 번째 접근 방법.
     * */
    /*public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        map = new HashMap<>();

        int result = 0;
        while (root != null) {
            if (root.val == k) {
                result = root.val;
                break;
            } else if (k < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return result;
    }*/


    /*
     * 두 번째 접근 방법.
     * bst -> root 보다 작은 값을 left child 로, root 보다 큰 값을 right child 로 가지는 특징이 있다.
     * 이를 이용한다면 inOrder (즉, 중위순회)를 통해 정렬된 배열 값을 얻을 수 있다.
     * 여기서 k-1번째 원소에 접근한다면 k번 째로 작은 원소를 구할 수 있다.
     * */
    private static ArrayList<Integer> list;

    public static int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();

        inorder(root);
        System.out.println(list);
        return list.get(k - 1);
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
