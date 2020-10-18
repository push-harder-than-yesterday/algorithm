package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println("result: " + lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        // 첫번째 풀이
        // 반복문을 돌며 contains가 false 일 때 까지 StrBuilder에 값을 추가하고
        // contains 가 true가 되었을 때 max 값을 비교해서 갱신한다.
        // -> "dvdf" 와 같이 앞에 값부터 다시 봐야 하는 케이스도 있다.
//        int max = 1;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (sb.toString().contains(String.valueOf(c))) {
//                sb.delete(0, sb.length());
//            }
//            sb.append(c);
//            max = Math.max(max, sb.length());
//        }

        // 두번째 풀이
        // 특정 좌표부터 max를 다 구해보자.
        int max = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.delete(0, sb.length());
            char base = s.charAt(i);
            sb.append(base);
            for (int j = i + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                if (sb.toString().contains(String.valueOf(c))) {
                    break;
                }
                sb.append(c);
            }
            max = Math.max(max, sb.length());
        }

        return max;
    }
}
