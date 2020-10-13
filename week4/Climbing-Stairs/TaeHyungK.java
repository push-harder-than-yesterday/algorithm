package leetcode;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("result: " + climbStairs(n));
    }

    private static int climbStairs(int n) {
        if (n <= 1) return n;

        // 1 = 1 1
        // 2 = 2 1+1/2
        // 3 = 3 1+1+1/1+2/2+1
        // 4 = 5 1+1+1+1/1+1+2/1+2+1/2+1+1/2+2
        // 5 = 8 1+1+1+1+1/1+1+1+2/1+1+2+1/1+2+1+1/2+1+1+1/1+2+2/2+1+2/2+2+1
        // 6 = 13  1+1+1+1+1+1/1+1+1+1+2/1+1+1+2+1/1+1+2+1+1/1+2+1+1+1/2+1+1+1+1/1+1+2+2/1+2+2+1/1+2+1+2/2+1+1+2/2+1+2+1/2+2+1+1/2+2+2
        // 첫번째 풀이 3부터는 앞에 2개를 더한 게 답이 된다.
        int[] counts = new int[n + 1];
        counts[0] = 1;
        counts[1] = 2;
        for (int i = 2; i < n; i++) {
            counts[i] = counts[i - 1] + counts[i - 2];
        }

        return counts[n - 1];
    }
}
