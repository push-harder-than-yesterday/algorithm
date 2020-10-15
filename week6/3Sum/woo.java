package week6.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by victory_woo on 2020/10/12
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{}));
        System.out.println(threeSum(new int[]{0}));
    }

    // [-4,-1,-1,0,1,2]일 때
    // i = 1일 때, 이미 -1, 0, 1로 합이 0이 됨으로 result 에 추가되었다.
    // i = 2일 때, -1,0,1로 합이 0이 될 수 있으므로 nums[i-1] == nums[i]이라면 이미 이전 조합에서 정답을 구했을 것이기 때문에
    // 현재 i는 건너뛴다.
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (0 < i && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (nums[left] == nums[left - 1] && left < right) left++;
                    while (nums[right] == nums[right + 1] && left < right) right--;
                } else if (0 < sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    /*private static int[] check;
    private static List<List<Integer>> result;
    private static HashSet<String> set;

    // 첫 번째 접근 방법 : 조합.
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        set = new HashSet<>();
        result = new ArrayList<>();
        check = new int[3];

        combination(nums.length, 3, 0, 0, nums);

        return result;
    }

    private static void combination(int n, int r, int index, int target, int[] nums) {
        if (r == 0) {
            checkSum(nums);
            return;
        }

        if (target == n) return;

        check[index] = target;
        combination(n, r - 1, index + 1, target + 1, nums);
        combination(n, r, index, target + 1, nums);
    }

    private static void checkSum(int[] nums) {
        List<Integer> subList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        for (int index : check) sum += nums[index];

        if (sum == 0) {
            for (int index : check) {
                subList.add(nums[index]);
                sb.append(nums[index]);
            }

            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                result.add(subList);
            }
        }
    }*/
}