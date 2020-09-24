// 문제: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/

public class RotateArray {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
//        int[] nums = {-1};
        int[] nums = {1,2};
        int k = 3;

        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        // 첫번쨰 풀이
        // 이중 포문을 이용해서 맨 뒤에 값은 앞으로 빼고 한칸 씩 뒤로 밀도록 처리
//        for (int i = 0; i < k; i++) {
//            int lastValue = nums[nums.length - 1];
//            System.out.println("lastValue: " + lastValue);
//            for (int j = nums.length - 1; j > 0; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = lastValue;
//        }

        // 효율적인 알고리즘을 본 후... 이렇게 푼 사람들이 대단하다고 생각했다..
        // 1. 전체 배열을 한번 다 뒤집는다.
        // 2. 0 ~ k - 1 까지의 값을 다시 뒤집는다.
        // 3. 남은 k ~ 마지막 까지의 값을 다시 뒤집는다.
        // 배열의 크기가 k보다 작을 경우 예외 처리를 위해서는 length 값을 계산해주는 작업이 필요하다.
        int length = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, length - 1);
        reverse(nums, length, nums.length - 1);

        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
