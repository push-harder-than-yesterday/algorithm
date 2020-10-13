package week4.FirstBadVersion;

/**
 * created by victory_woo on 2020/09/23
 */
public class woo {
    public static void main(String[] args) {

    }

    // 첫 번째 접근 방법
    /*public int firstBadVersion(int n) {
        for (int i = 1; i < n; i++) {
            if (isBadVersion(i)) return i;
        }
        return n;
    }*/

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean isBadVersion(int version) {
        return version < 1;
    }
}
