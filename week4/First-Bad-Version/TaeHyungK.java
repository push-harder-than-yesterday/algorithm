package leetcode;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("result: " + firstBadVersion(n));
    }

    private static int firstBadVersion(int n) {
        // 첫번째 풀이
        // 그냥 앞에서부터 순차적으로 찾아본다.
        //  -> Time Limit Exceeded 로 실패. 역시나 효율성이 필요하다.
//        int result = 0;
//        for (int i = 0; i <= n; i++) {
//            result = i;
//            if (isBadVersion(i)) {
//                break;
//            }
//        }
//        return result;

        // 두번째 풀이
        // 이진 탐색으로 left, right 의 위치를 줄여가며 찾는다.
        // mid를 계산하는 수식을 못세워서 고전했다. 그냥 (left + right) / 2 할 경우 int로 인해 소수점을 버리는 현상이 발생하고
        // 그렇다고 double 로 선언한 후 ceil(올림) 을 하면 무한 루프에 빠지는 현상이 있었다.
        if (n == 1) return 1;
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static boolean isBadVersion(int version) {
        if (version >= 4) return true;
        else return false;
    }
}
