package week5.PowerofThree;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(45));
    }

    // int 범위 벗어남.
    /*public static boolean isPowerOfThree(int n) {
        int v = 1;
        while (true) {
            if (v == n) return true;

            if (n < v) break;
            v = v * 3;
        }
        return false;
    }*/

    /*public static boolean isPowerOfThree(int n) {
        if (n < 1) return false;

        while (n % 3 == 0) n = n / 3;

        return n == 1;
    }*/

    // Solution 3
    // 진법이용.
    public static boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
