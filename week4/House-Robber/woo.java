package week4.HouseRobber;

/**
 * created by victory_woo on 2020/09/24
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(rob(new int[]{2, 7, 9, 3, 1})); // 12
        System.out.println(rob(new int[]{2, 1, 1, 2})); // 4
    }

    // 예외 : [2,1,1,2]
    // expected : 4
    // actual : 3
/*    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int sum;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            sum = nums[i];
            for (int j = i + 2; j < nums.length; j += 2) {
                sum += nums[j];
            }

            max = Math.max(max, sum);
        }

        return max;
    }*/

/*    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = new int[len + 1];

        for (int i = 0; i < len; i++) {
            dp[i + 1] = nums[i];
        }

        dp[2] = dp[1] < dp[2] ? dp[2] : dp[1];
        for (int i = 3; i <= len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i]);
        }


        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (max < dp[i]) max = dp[i];
        }

        return max;
    }*/

    // 세번째 접근 방법.
    // 초기값을 지정해준다.
    // dp[n] = n번째 집에 방문했을 때, 도둑이 얻을 수 있는 최대 이익.
    // 2부터 시작하며, 현재 집 기준으로 한칸 띄어서 떨어진 집을 도둑이 방문했을 때의 최대 이익 = dp[i-2]
    // 현재 집이 갖고 있는 돈 = nums[i]
    // 이전 집까지 도둑이 방문했을 때의 최대 이익 = dp[i-1]
    // max(dp[i-2]+nums[i], dp[i-1])
    // dp[i-1]이 더 커서 이전 집까지의 최대값이 그대로 dp[i]에 오는 경우가 있다.
    // 이 경우는 i 번째 집은 방문하지 않는 것이 도둑의 이익을 최대화시키는 방법이 되는 것이다.
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        for (int d : dp) System.out.print(d + " ");

        return dp[dp.length - 1];
    }
}
