package week5.HammingDistance;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        String a = Integer.toBinaryString(x);
        String b = Integer.toBinaryString(y);
        if (a.length() < b.length()) a = insertZero(a, b.length());
        else b = insertZero(b, a.length());

        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }

        return count;
    }

    static String insertZero(String s, int len) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < len) sb.insert(0, 0);

        return sb.toString();
    }
}
