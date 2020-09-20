package leetcode.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * created by victory_woo on 2020/09/18
 * 첫 번째 접근 방법
 *
 * 1) 트리의 level에 따라서 list에 추가하여 List<List<Int>> 결과를 반환해야 한다.
 * 2) 트리의 level별로 접근할 필요가 있다. 트리를 큐에 담아서 node의 left, right에 접근하여 null이 아닌 경우, 큐에 담고 node의 값을 contains에 담는다.
 * 3) 문제 : 예시의 경우는 가능하지만, 9의 왼쪽 서브트리가 10, 오른쪽 서브트리가 2라면 결과가 다르게 나온다.
 * // 원래 결과
 * [[3],
 *  [9,20],
 *  [10,2,15,7]
 * ]
 *
 * // 잘못된 결과
 * [[3],
 *  [9,20],
 *  [10,2],
 *  [15,7]
 * ]
 * 4) 따라서 트리의 깊이만큼 도는 반복문이 하나 더 필요하다..
 *
 *
 * 두 번째 접근 방법
 *
 * 1) root를 큐에 넣는다. 그리고 bfs 탐색을 진행한다.
 * 2) 큐의 사이즈를 구하여 큐에 들어있는 노드만큼 반복문을 돌며 들어있는 노드들을 모두 뺀다.
 * 3) 큐에서 뺀 노드의 val을 contains에 넣는다. 그리고 node의 left, right가 null이 아니라면 left, right를 큐에 넣어준다.
 * 4) 반복문은 처음에 확인한 큐의 사이즈만큼만 반복되기 때문에 트리의 level 별로 큐에 들어가게 된다.
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);
        for (List<Integer> list : result) {
            for (int value : list) System.out.print(value + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 최종 결과를 담는다.
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> contains;

        // 큐에 root 를 넣어준다.
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            contains = new ArrayList<>();

            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.remove();
                contains.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            result.add(contains);
        }
        return result;
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
