package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println("result: " + missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        int result = 0;

        // 첫번째 풀이
        // 배열을 정렬해서 위치 찾기
//        Arrays.sort(nums);
//        if (nums[0] != 0) return 0;
//
//        boolean isChecked = false;
//
//        int before = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != (before + 1)) {
//                result = before + 1;
//                isChecked = true;
//                break;
//            }
//
//            before = nums[i];
//        }
//
//        return isChecked ? result : nums[nums.length - 1] + 1;

        // 두번째 풀이
        // 자료구조 Set을 이용해서 빈 구역 찾기
//        Set<Integer> data = Arrays.stream(nums).boxed().collect(Collectors.toSet()); // 속도가 느려서 직접 add 로 변경
        Set<Integer> data = new HashSet<>();
        for (int num : nums) {
            data.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!data.contains(i)) return i;
        }
        return 0;
    }
}
