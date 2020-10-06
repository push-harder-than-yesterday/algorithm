package leetcode;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution obj = new Solution(nums);
        obj.shuffle();
        obj.reset();
        obj.shuffle();
    }

    private static class Solution {
        private int[] origin;
        private int[] nums = null;

        public Solution(int[] nums) {
            origin = nums;
            this.nums = Arrays.copyOf(nums, nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            nums = Arrays.copyOf(origin, origin.length);
            System.out.println("----reset----");
            System.out.println(Arrays.toString(origin));
            System.out.println(Arrays.toString(nums));
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int randomIndex = random.nextInt(nums.length);
                int temp = nums[randomIndex];
                nums[randomIndex] = nums[i];
                nums[i] = temp;
            }
            System.out.println("----shuffle----");
            System.out.println(Arrays.toString(origin));
            System.out.println(Arrays.toString(nums));
            return nums;
        }
    }
}
