package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// 3Sum
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("result: " + threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        // 힌트를 봐도 잘 모르겠어서 solution을 찾아봤다.
        // 1. 오름차순으로 정렬한다.
        // 2. 특정한 값 i를 정하고, 배열의 left와 right의 합을 더해 0인지 체크한다.
        // 3. 합이 0보다 클 경우 right를 1 감소해 더 작은 값을 돌게 한다.
        // 4. 합이 0보다 작을 경우 left를 1 증가해 더 큰 값을 돌게 한다.
        // 5. 모든 특정한 값 i 에 대한 sum == 0 인 리스트를 찾는다.
        Arrays.sort(nums);

        HashSet<List<Integer>> setData = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    setData.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // 현재가 이전 아이템과 같은 값인 경우 무시한다.
                    while (nums[left] == nums[left - 1] && left < right) left++;
                    while (nums[right] == nums[right + 1] && left < right) right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(setData);
    }
}
