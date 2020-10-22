package week7.SerializeandDeserializeBinaryTree;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/10/22
 */
public class woo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        System.out.println(codec.deserialize(codec.serialize(root)));
    }

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            LinkedList<TreeNode> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            q.add(root);

            while (!q.isEmpty()) {
                TreeNode cur = q.remove();
                if (cur == null) {
                    sb.append("n ");
                    continue;
                }

                sb.append(cur.val).append(" ");
                q.add(cur.left);
                q.add(cur.right);
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) return null;

            LinkedList<TreeNode> q = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(toInt(values[0]));
            q.add(root);

            for (int i = 1; i < values.length; i++) {
                TreeNode parent = q.remove();
                if (!values[i].equals("n")) {
                    TreeNode left = new TreeNode(toInt(values[i]));
                    parent.left = left;
                    q.add(left);
                }

                if (!values[++i].equals("n")) {
                    TreeNode right = new TreeNode(toInt(values[i]));
                    parent.right = right;
                    q.add(right);
                }
            }
            return root;
        }

        private int toInt(String s) {
            return Integer.parseInt(s);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
