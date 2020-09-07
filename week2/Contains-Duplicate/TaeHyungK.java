// 문제: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("result: " + containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        // 첫번째 풀이
        // O(N^2) 인 이중 for문을 통해 모든 배열 탐색을 한다.
        //  -> 굉장히 많은 데이터가 들어오는 경우 시간 초과로 실패한다.
//        boolean result = false;
//        for (int i = 0; i < nums.length; i++) {
//            int base = nums[i];
//            for (int j = 0; j < nums.length; j++) {
//                if (i == j) continue;
//
//                int num = nums[j];
//                if (base == num) {
//                    result = true;
//                    break;
//                }
//            }
//        }

        // 두번째 풀이
        // 첫번쨰 풀이와 비슷하지만 내 뒤에 아이템들만 비교해서 불필요한 반복을 줄였다.
        //  -> 답이 통과는 되지만 Runtime이 835ms 로 매우 긴 시간을 사용하게 된다.
//        boolean result = false;
//        for (int i = 0; i < nums.length; i++) {
//            int base = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                int num = nums[j];
//                if (base == num) {
//                    result = true;
//                    break;
//                }
//            }
//        }

        // 세번째 풀이
        // 중복되지 않는 자료구조 `Set` 을 이용한 풀이이다.
        // 입력된 nums와 생성된 set의 갯수를 비교하여 같지 않을 경우 중복됐다고 판단한다.
        Set<Integer> data = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length != data.size();
    }
}