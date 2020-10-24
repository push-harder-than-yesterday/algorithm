package leetcode;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        ArrayList<String> list = new ArrayList<>();
        serializeRecursive(root, list);

        return list.toString();
    }

    // StringBuilder를 이용해서 BFS를 하고 싶었는데
    // 콤마(,) 같은 구분자를 어떻게 해야 할지 몰라 솔루션을 봤다.
    // 리스트를 통해서 자동으로 콤마를 채우는 방식이다. 신기하다..
    private void serializeRecursive(TreeNode root, ArrayList<String> list) {
        if (root == null) {
            return;
        }

        list.add(String.valueOf(root.val));

        if (root.left != null) {
            serializeRecursive(root.left, list);
        } else {
            list.add("null");
        }

        if (root.right != null) {
            serializeRecursive(root.right, list);
        } else {
            list.add("null");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        List<String> list = Arrays.asList(data.replace("[", "").replace("]", "").split(","));
        TreeNode result = deserializeRecursive(new ArrayList<>(list));
        return result;
    }

    // serialize 솔루션을 보면서 함께 참고했다..
    // 진짜 대단한 사람들이 많다..
    private TreeNode deserializeRecursive(List<String> list) {
        String item = list.remove(0).trim();
        if ("null".equals(item)) {
            return null;
        } else {
            int val = Integer.parseInt(item);
            TreeNode root = new TreeNode(val);
            root.left = deserializeRecursive(list);
            root.right = deserializeRecursive(list);
            return root;
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
