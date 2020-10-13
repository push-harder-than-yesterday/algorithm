package week4.MaximumSubarray;

/**
 * created by victory_woo on 2020/09/24
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, 1}));
    }

    /*public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int s = 0, e = 0;
        int max = 0;
        while (true) {
            int sum = 0;
            for (int i = s; i <= e; i++) sum += nums[i];

            if (sum < 0) {
                e++;
            } else if (e == nums.length - 1) {
                break;
            } else {
                s++;
                max = Math.max(max, sum);
            }
        }

        return max;
    }*/


    /*private static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }

        max = Math.max(max, sum);

        return max;
    }*/

    // 솔루션 : 카데인 알고리즘.
    /*private static int maxSubArray(int[] nums) {
        int bestSum = Integer.MIN_VALUE;
        int endSum = 0;

        for (int num : nums) {
            endSum = Math.max(endSum + num, num);
            bestSum = Math.max(bestSum, endSum);
        }

        return bestSum;
    }*/

    private static int maxSubArray(int[] nums) {
        int localMax = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            max = Math.max(max, localMax);
        }
        return max;
    }

}
