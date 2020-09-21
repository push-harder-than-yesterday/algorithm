package leetcode.week3;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/18
 */
public class SymmetricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        // 큐에 root를 두번 넣는다.
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            /// 두 개의 노드를 뺀다.
            TreeNode a = q.remove();
            TreeNode b = q.remove();

            // 둘 다 null이라면 return true가 아닌 continue를 한다.
            // 이 노드를 제외하더라도 대칭이 될 수 있기 때문에 큐에 들어간 모든 노드를 검사해야 한다.
            if (a == null && b == null) continue;
            // 둘 중 하나라도 널이라면 이는 대칭이 아니므로 false 반환.
            if (a == null || b == null) return false;
            // 값이 다르다면 당연히 false 반환.
            if (a.val != b.val) return false;

            // 큐에 a의 왼쪽과 b의 오른쪽
            // a의 오른쪽과 b의 왼쪽
            // 순서대로 노드를 넣어준다.
            q.add(a.left);
            q.add(b.right);
            q.add(a.right);
            q.add(b.left);
        }
        // 여기까지 왔다면 대칭이므로 true 반환.
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
