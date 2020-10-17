package leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "abcda";
        System.out.println("result: " + longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        String result = s;

        // 첫번째 풀이
        // left, right를 줄여가면서 같은지 체크하여 같지 않은 경우 제거 대상 index로 넣고
        // 마지막에 해당 Index 리스트를 모두 제거한다.
        // -> 문제를 잘못 이해함. 맨 앞부터 palindrome 이 어디까지인지를 체크해나가야할듯?
//        int left = 0;
//        int right = s.length() -1;
//        while (left < right) {
//            char leftChar = s.charAt(left);
//            char rightChar = s.charAt(right);
//            if (leftChar != rightChar) {
//                StringBuffer sb = new StringBuffer(s);
//                sb.deleteCharAt(right);
//                sb.deleteCharAt(left);
//
//                s = sb.toString();
//                left = 0;
//                right = s.length() - 1;
//                continue;
//            }
//
//            left++;
//            right--;
//        }
//
//        StringBuffer sb = new StringBuffer(s);
//
//        return sb.toString();

        // 두번째 풀이
        // O(N^3) 이긴 하지만.. 반복문을 계속 돌려가며 모든 값을 찾는다.
        // -> "aaa" 같이 모든 값이 같은 경우, "abcda" 와 같은 것을 체크하지 못한다.. 왜지..?
        //    아예 접근이 잘못된 것 같다.
//        if (s == null || isAllSame(s)) return s;
//        else if (s.length() == 2) {
//            return isPalindrome(s, 0, 1) ? s : s.substring(0, 1);
//        }
//
//        int max = 0;
//        for (int i = s.length() - 1; i > 0; i--) {
//            int left = 0;
//            int right = i;
//
//            while (right < s.length()) {
//                if (isPalindrome(s, left, right)) {
//                    String subStr = s.substring(left, right + 1);
//                    boolean needUpdate = max < subStr.length();
//                    result = needUpdate ? subStr : result;
//                    max = needUpdate ? subStr.length() : max;
//                }
//                left++;
//                right++;
//            }
//        }
//
//        return result;

        // 세번째 풀이
        // 잘 모르겠습니다.. 혹시 푸신분 설명 좀 부탁드려요...
        if (s == null || s.length() <= 1) return s;

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {

        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isAllSame(String s) {
        char base = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (base != s.charAt(i)) return false;
        }
        return true;
    }
}
