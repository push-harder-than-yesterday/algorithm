package week4.ConvertSortedArraytoBinarySearchTree;

/**
 * created by victory_woo on 2020/09/24
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        System.out.println(sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5}));
    }

    // 첫번째 접근.
    // 중간을 찾아서 root 로 지정
    // 중간 왼쪽은 root 의 왼쪽 서브트리로
    // 중간 오른쪽은 root 의 오른쪽 서브트리로 만든다.
    /*public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode pointer = root;

        // 왼쪽 구성.
        for (int i = mid - 1; i >= 0; i--) {
            pointer.left = new TreeNode(nums[i]);
            pointer = pointer.left;
        }

        pointer = root;
        for (int i = nums.length - 1; i > mid; i--) {
            if (pointer.val < nums[i]) {
                pointer.right = new TreeNode(nums[i]);
                pointer = pointer.right;
            } else {
                pointer.left = new TreeNode(nums[i]);
                pointer = pointer.left;
            }
        }

        return root;
    }*/

    // 솔루션 접근
    // 재귀 호출로 접근한다.
    // 매 순간의 root 를 정하고
    // root 기준으로 왼쪽과 오른쪽 서브 트리를 구성하도록 한다.
    // 모두 같은 동작을 수행.
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
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
