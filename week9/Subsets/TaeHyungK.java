package leetcode;

import java.util.*;

public class SubSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("result: " + subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 첫번째 풀이.
        // 앞서 풀었던 순열을 결과에 맞춰가며 풀이.
        // 중복된 데이터를 제거하기 위해 자료구조 `Set` 사용
        // Permutations 문제와 동일하지만 결과 데이터를 넣을 때 r 개를 뽑은 것처럼 r 까지만 리스트를 구성하여 넣어준다.
        // 단, nums.length 만큼 골랐을 때는 for 문을 돌지 않기 때문에 따로 넣어줌.
        //  -> 순서가 없는 순열이라 {1,3}, {3,1} 과 같이 모든 값이 들어가게 되어 틀림.
//        List<Integer> first = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            first.add(nums[i]);
//        }
//        result.add(first);
//
//        Set<List<Integer>> setData = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            permutation(nums, 0, i, setData);
//        }
//
//        result.addAll(setData);

        // 두번째 풀이.
        // 구글링으로 조합을 구하는 방법을 찾아보았다.
        // 공식같은 조합 문제인데 머리가 굳었는지 이해가 잘 되지 않는다... 디버깅을 천천히 다시 해봐야겠다.
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i <= nums.length; i++) {
            combination(nums, visited, 0, i, result);
        }

        return result;
    }

    private static void combination(int[] nums, boolean[] visited, int depth, int r, List<List<Integer>> result) {
        if (r == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    list.add(nums[i]);
                }
            }
            result.add(list);
            return;
        }

        if (depth == nums.length) {
            return;
        }
        visited[depth] = true;
        combination(nums, visited, depth + 1, r - 1, result);

        visited[depth] = false;
        combination(nums, visited, depth + 1, r, result);
    }

//    private static void permutation(int[] nums, int depth, int r, Set<List<Integer>> setData) {
//        if (depth == r) {
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < r; i++) {
//                list.add(nums[i]);
//            }
//            setData.add(list);
//            return;
//        }
//
//        for (int i = depth; i < nums.length; i++) {
//            swap(nums, depth, i);
//            permutation(nums, depth + 1, r, setData); // 재귀를 통해 순열을 만듦.
//            swap(nums, depth, i); // 다음 순열을 찾기 위해 백트래킹(원상복귀)
//        }
//    }
//
//    private static void swap(int[] nums, int depth, int i) {
//        int temp = nums[depth];
//        nums[depth] = nums[i];
//        nums[i] = temp;
//    }
}
