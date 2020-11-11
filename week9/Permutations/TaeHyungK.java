package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println("result: " + permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        // 일반적인 순열문제.
        // 예전에 풀었던 순열문제를 찾아서 사용했다.
        List<List<Integer>> result = new ArrayList<>();
        permutation(nums, 0, result);
        return result;
    }

    private static void permutation(int[] nums, int depth, List<List<Integer>> result) {
        if (depth == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }

        for (int i = depth; i < nums.length; i++) {
            swap(nums, depth, i);
            permutation(nums, depth + 1, result); // 재귀를 통해 순열을 만듦.
            swap(nums, depth, i); // 다음 순열을 찾기 위해 백트래킹(원상복귀)
        }
    }

    private static void swap(int[] nums, int depth, int i) {
        int temp = nums[depth];
        nums[depth] = nums[i];
        nums[i] = temp;
    }
}
