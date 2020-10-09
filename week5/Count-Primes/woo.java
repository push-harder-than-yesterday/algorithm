package week5.CountPrimes;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
    }

    // n보다 작아야 하는데, n보다 작거나 같은 조건으로 찾고 있었음..
    public static int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        boolean[] check = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (check[i]) continue;

            for (int j = i + i; j <= n; j += i) check[j] = true;
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!check[i]) count++;
        }

        return count;
    }
}
