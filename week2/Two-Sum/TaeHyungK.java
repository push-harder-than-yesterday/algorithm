package leetcode;

public class TwoSum {
    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        int[] nums = {3,2,4};
//        int target = 6;
        int[] nums = {3,3};
        int target = 6;

        System.out.println("result");
        int[] result = twoSum(nums, target);
        for (int item : result) {
            System.out.print(item + ",");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        // 첫번째 풀이
        // 하나를 선택하고 target - 자기자신을 통해 다른 값을 구한 후
        // 자기자신을 제외하고 다른 값중에 그게 있는지 체크
        for (int i = 0; i < nums.length; i++) {
            int second = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[j] == second) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }
}
