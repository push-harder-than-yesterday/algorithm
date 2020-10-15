package leetcode;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(countPrimes(n));
    }

    private static int countPrimes(int n) {
        // 이 문제의 테스트 케이스에서 2의 정답은 0이라고 한다.
        // 왜? 2는 소수인데?
        if (n <= 2) return 0;

        // 첫번째 풀이
        // 이중 for문을 돌며 사이즈 체크
        //  -> 시간 초과로 실패.


//        int size = 0;
//        for (int i = 2; i <= n; i++) {
//            boolean isPrime = true;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//
//            if (isPrime) size++;
//        }
//
//        return size;


        // 두번째 풀이
        // 에라토스테네스의 체 를 이용한 소수 구현
        int size = 0;
        boolean[] prime = new boolean[n + 1];
        int i, j;

        // 소수를 넣을 배열을 0으로 초기화
        // 0 - 소수, 1 - 소수가 아님
        for (i = 0; i < n; i++) {
            prime[i] = true;
        }
        prime[1] = false;

        // 2부터 시작하여 배수들은 소수에서 제외
        for (i = 2; i <= n; i++) {
            for (j = 2; i * j <= n; j++) {
                prime[i * j] = false;
            }
        }

        for (i = 1; i <= n; i++) {
            // 소수인 경우 size 증가
            if (prime[i]) size++;
        }

        return size;
    }
}
