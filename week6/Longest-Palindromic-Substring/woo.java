package week6.LongestPalindromicSubstring;

/**
 * created by victory_woo on 2020/10/13
 */
public class woo {
    public static void main(String[] args) {
        System.out.println("Result : " + longestPalindrome("babad"));
        System.out.println("Result : " + longestPalindrome("cbbd"));
        System.out.println("Result : " + longestPalindrome("ac"));
        System.out.println("Result : " + longestPalindrome("bb"));
        System.out.println("Result : " + longestPalindrome("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"));
    }

    // 3번째 접근 방법.
    // dp.
    public static String longestPalindrome(String s) {
        String answer = "";
        char[] ch = s.toCharArray();
        int maxN = 0;
        boolean[][] dp = new boolean[ch.length][ch.length];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = (ch[i] == ch[j] && (j - i <= 2 || dp[i + 1][j - 1]));

                // maxN : 가장 긴 팰린드롬을 찾기 위함!
                if (dp[i][j] && maxN <= j - i) {
                    maxN = j - i;
                    answer = s.substring(i, j + 1);
                }
            }
        }
        return answer;
    }

/*    public static String longestPalindrome(String s) {
        String answer = "";
        int max = 0;
        for (int i = s.length(); i > 0; i--) {
            int start = 0;
            int end = i - 1;

            while (end < s.length()) {
                if (isPalindrome(s, start, end)) {
                    String str = s.substring(start, end + 1);
                    if (max < str.length()) {
                        max = str.length();
                        answer = str;
                    }
                }
                start++;
                end++;
            }
        }

        return answer;
    }


    private static boolean isPalindrome(String s, int start, int end) {
        int mid = (end - start + 1) / 2;

        for (int i = 0; i < mid; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) return false;
        }
        return true;
    }*/

    /*public static String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;

        ArrayList<String> list = new ArrayList<>();

        StringBuilder sb;
        for (int i = 0; i < s.length(); i++) {
            sb = new StringBuilder();
            sb.append(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {

                if (isPalindrome(sb.toString())) {
                    list.add(sb.toString());
                }

                sb.append(s.charAt(j));
            }
            if (isPalindrome(sb.toString())) {
                list.add(sb.toString());
            }
        }

        System.out.println(list);

        int max = list.get(0).length();
        String ans = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            String str = list.get(i);
            if (max < str.length()) {
                max = str.length();
                ans = str;
            }
        }

        return ans;
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();
        int mid = len / 2;

        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        return true;
    }*/

}
