// 문제: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        String s = "0P";
        System.out.println("result: " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        // 첫번째 풀이
        // 정규표현식을 통해 문자와 숫자를 제외한 값들은 제거한다.
        // 해당 값을 reverse 한후 대소문자 비교를 무시하는 `equalsIgnoreCase()` 를 통해 비교한다.
        // -> 이건 약간 치트키같은 느낌이다.
//        String str = s.replaceAll("[^A-Za-z0-9]", "");
//        String reverseStr = new StringBuilder(str).reverse().toString();
//        return str.equalsIgnoreCase(reverseStr);
//
        // 두번째 풀이
        // left, right 를 두고 교차할 때까지 비교한다.
        // -> 솔직히 이 문제는 예전에 팰린드롬 문제를 풀어봤어서 기억났다.
        if (s.length() <= 1) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < s.length() && !(Character.isLetterOrDigit(s.charAt(left)))) {
                // 숫자나 문자가 아닌 경우 무시
                left++;
            }
            while (right >= 0 && !(Character.isLetterOrDigit(s.charAt(right)))) {
                // 숫자나 문자가 아닌 경우 무시
                right--;
            }
            if (left >= right) break;

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
}
