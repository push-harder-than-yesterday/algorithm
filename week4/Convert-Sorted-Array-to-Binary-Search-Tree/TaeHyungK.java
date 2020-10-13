package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
//        int[] nums = {-10, -3, 0, 5, 9};
//        int[] nums = {0};
//        int[] nums = {};
        int[] nums = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        TreeNode result = sortedArrayToBST(nums);
        System.out.println("result: " + result);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        // 첫번째 풀이
        // 정렬된 상태이기 때문에 주어진 배열의 가운데가 head가 된다.
        // head를 기준으로 left, right 를 배열로 나눠 mid 값을 root로 계속 만들어나감
        // 단, right의 경우 인덱스를 통한 값을 얻기 위한 것이 아닌 중간 위치를 찾기 위한 인덱스이므로
        // -1 을 해주지 않아야 한다. (-1을 해줄 경우 length가 짝수일 때에 정상적인 중간값을 찾을 수 없다)
        TreeNode midNode = addNode(nums, 0, nums.length);
        return midNode;
    }

    private static TreeNode addNode(int[] nums, int left, int right) {
        if (left == right) return null;
        int midIndex = (left + right) / 2;
        TreeNode node = new TreeNode(nums[midIndex]);
        node.left = addNode(nums, left, midIndex);
        node.right = addNode(nums, midIndex + 1, right);
        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * 배열을 잘라서 했을 때.
 */
class WithSlice {
    public static void main(String[] args) {
//        int[] nums = {-10, -3, 0, 5, 9};
//        int[] nums = {0};
//        int[] nums = {};
        int[] nums = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        TreeNode result = sortedArrayToBST(nums);
        System.out.println("result: " + result);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        // 첫번째 풀이
        // 정렬된 상태이기 때문에 주어진 배열의 가운데가 head가 된다.
        // head를 기준으로 left, right 를 배열로 나눠 mid 값을 root로 계속 만들어나감
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        TreeNode midNode = addNode(list);
        return midNode;
    }

    private static TreeNode addNode(List<Integer> list) {
        //                 left   right
        // left 트리 구성 시    0   /   -1  일 때 무한 루프
        // right 트리 구성 시   1   /   0   일 때 무한 루프
        // 2depth left 구성   2   /   0   일 때 무한 루프
        if (list.size() <= 0) return null;

        int midIndex = list.size() / 2;
        TreeNode node = new TreeNode(list.get(midIndex));

        // slice
        List<Integer> leftList = list.subList(0, midIndex);
        List<Integer> rightList = list.subList(midIndex + 1, list.size());
        node.left = addNode(leftList);
        node.right = addNode(rightList);
        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}