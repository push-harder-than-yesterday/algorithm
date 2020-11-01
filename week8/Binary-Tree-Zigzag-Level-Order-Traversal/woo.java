package week8.BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

/**
 * created by victory_woo on 2020/10/25
 */
public class woo {
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/

        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        leftChild.left = new TreeNode(4);
        leftChild.right = null;
        TreeNode rightChild = new TreeNode(3);
        rightChild.left = null;
        rightChild.right = new TreeNode(5);
        root.left = leftChild;
        root.right = rightChild;

        zigzagLevelOrder(root);
    }

    /*
     * 첫 번째 접근 방법.
     *
     * */
    /*public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        int state = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new ArrayList<>();
            if (state > 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.remove();
                    if (cur != null) {
                        sub.add(cur.val);

                        if (cur.left != null) q.add(cur.left);
                        if (cur.right != null) q.add(cur.right);
                    }
                }
            } else {
                for (int i = size - 1; i >= 0; i--) {
                    TreeNode cur = q.remove(i);
                    if (cur != null) {
                        sub.add(cur.val);

                        if (cur.left != null) q.add(cur.left);
                        if (cur.right != null) q.add(cur.right);
                    }
                }
            }
            state = state * -1;

            if (!sub.isEmpty()) result.add(sub);
        }

        for (List<Integer> list : result) System.out.println(list);

        return result;
    }*/


    /*
    * 두 번째 접근 방법.
    * 첫 번째 방법과 유사하다.
    * 여기서 읽는 순서는 기본적으로 left to right 라고 가정했다.
    *
    * left to right : 읽는 순서와 추가하는 순서가 일치하도록 sub.addLast()를 호출한다.
    * right to left : 읽는 순서와 추가하는 순서가 반대가 되도록 sub.addFirst()를 호출한다.
    *
    * ex) [2,3]이 right to left 인 경우. 2->3으로 읽지만 [3,2]로 추가되어야 한다.
    *
    * addFirst(2)
    * (first)
    *   [2      ]
    * addFirst(3)
    * (first)
    *   [3  2   ]
    * 위처럼 된다고 보면 된다.
    * */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean left = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> sub = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();

                if (left) sub.addLast(cur.val);
                else sub.addFirst(cur.val);

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }

            left = !left;
            if (sub.size() > 0) result.add(sub);
        }

        for (List<Integer> list : result) System.out.println(list);

        return result;
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
