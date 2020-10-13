package week4.ClimbingStairs;

/**
 * created by victory_woo on 2020/09/24
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(10));
        //System.out.println(climbStairs(44));
    }

    // 첫 번째 접근 방법
    // 재귀 호출. -> n : 44이면 시간초과 발생.
    /*static int count;

    public static int climbStairs(int n) {
        count = 0;
        solve(0, n);
        return count;
    }

    private static void solve(int step, int top) {
        if (step >= top) {
            if (step == top) count++;
            return;
        }

        solve(step + 1, top);
        solve(step + 2, top);
    }*/

    // 두번째 접근 방법.
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
