package week6.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;

/**
 * created by victory_woo on 2020/10/13
 */
public class woo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("au"));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }

    static class Solution {
        // 첫 번째 접근 방법.
        /*public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;

            HashMap<Character, Integer> map = new HashMap<>();
            int result = 1;
            int count = 1;

            char prev = s.charAt(0);
            map.put(prev, count);
            for (int i = 1; i < s.length(); i++) {
                char cur = s.charAt(i);

                if (!map.containsKey(cur)) {
                    count++;
                } else {
                    int temp = map.get(prev);
                    if (result < temp) result = temp;

                    count = 1;
                }
                map.put(cur, count);
                prev = cur;
            }

            int temp = map.size();
            if (result < temp) result = temp;

            return result;
        }*/

        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<>();

            int n = s.length();
            int begin = 0, end = 0;
            int answer = 0;

            while (end < n) {
                if (set.contains(s.charAt(end))) {
                    set.remove(s.charAt(begin++));
                } else {
                    set.add(s.charAt(end++));
                    answer = Math.max(answer, end - begin);
                }
            }

            return answer;
        }
    }
}
