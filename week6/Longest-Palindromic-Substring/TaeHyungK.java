package leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "abcda";
        System.out.println("result: " + longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
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
        //   +> result의 초기값을 문자열 s가 아닌 최소값인 s의 첫번째 값으로 하면 해결이 된다.
        //   +> 어차피 뒤에서부터 돌기 때문에 early return 을 하면 속도 개선이 가능하다.

        String result = s.substring(0, 1);
        for (int i = s.length() - 1; i > 0; i--) {
            int left = 0;
            int right = i;

            while (right < s.length()) {
                if (isPalindrome(s, left, right)) {
                    String subStr = s.substring(left, right + 1);
                    return subStr;
                }
                // bacda
                // abcd bcda
                // abc bcd cda
                // ...
                left++;
                right++;
            }
        }

        return result;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
