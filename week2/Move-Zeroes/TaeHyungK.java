package leetcode;

public class MoveZeroes {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0, 0, 1};
        int[] nums = {0, 0, 0};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        // 첫번째 풀이
        // 0을 찾으면 뒤에있는 애를 앞으로 땡겨오고 맨 뒤로 보내기
        int zeroSize = 0;
        boolean needInit = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (zeroSize > nums.length) break; // {0,0,0} 일 때 무한루프를 막기 위함
            if (needInit) {
                i = 0;
                needInit = false;
            }
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                zeroSize++;
                needInit = true;
            }
        }

        if (zeroSize >= nums.length) {
            return;
        }
        for (int i = nums.length - 1; i >= nums.length - zeroSize; i--) {
            nums[i] = 0;
        }

        // 결과 출력
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
