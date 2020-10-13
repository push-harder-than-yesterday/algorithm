package leetcode;

public class PowerOfThree {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(String.valueOf(isPowerOfThree(n)));
    }

    private static boolean isPowerOfThree(int n) {
        if (n < 0) return false;

        // 3^19가 int 범위 내의 최대 3의 제곱근 값
        double max = Math.pow(3, 19);
        return max % n == 0;
    }
}
