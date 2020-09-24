// 문제: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";

        String s = "cat";
        String t = "car";

        System.out.println("result: " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        boolean result = true;

        // 첫번째 풀이
        // 먼저, 애너그램은 글자 수의 길이가 같아야 한다.
        // 각 문자열을 char 배열로 만들고 정렬 한 후 비교한다.
        if (s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < sArray.length; i++) {
            char sChar = sArray[i];
            char tChar = tArray[i];

            if (sChar != tChar) {
                result = false;
                break;
            }
        }
        return result;
    }
}