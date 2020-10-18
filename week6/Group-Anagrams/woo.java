package week6.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * created by victory_woo on 2020/10/12
 */
public class woo {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        groupAnagrams(new String[]{"a"});
    }

    // 두 번째 접근 방법.
    // HashMap 사용.
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        System.out.println(map);
        return new ArrayList<>(map.values());
    }

    // 첫 번째 접근 방법
    // 비효율적..
    /*public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<word> words = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (String s : toStringArray(strs[i])) sb.append(s);

            words.add(new word(strs[i], sb.toString(), i));
        }

        boolean[] visited = new boolean[words.size()];
        for (int i = 0; i < words.size(); i++) {
            ArrayList<String> sub = new ArrayList<>();
            word a = words.get(i);
            if (!visited[i]) {
                sub.add(a.original);
                visited[i] = true;
            }
            for (int j = i + 1; j < words.size(); j++) {
                word b = words.get(j);
                if (a.anagram.equals(b.anagram) && !visited[j]) {
                    sub.add(b.original);
                    visited[j] = true;
                }
            }

            if (!sub.isEmpty()) result.add(sub);
        }

        return result;
    }

    private static String[] toStringArray(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr);
        return arr;
    }

    static class word {
        String original;
        String anagram;
        int index;

        public word(String original, String anagram, int index) {
            this.original = original;
            this.anagram = anagram;
            this.index = index;
        }

        @Override
        public String toString() {
            return "word{" +
                    "original='" + original + '\'' +
                    ", anagram='" + anagram + '\'' +
                    ", index=" + index +
                    '}';
        }
    }*/
}
