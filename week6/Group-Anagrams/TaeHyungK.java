package leetcode;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("result: " + groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        // 첫번째 풀이
        // 기존에 풀었던 anagram validate 를 하나 만들고
        // Anagram이 아닌 경우 새로운 리스트에 추가,
        // 기존 리스트 중에 Anagram이 있는 경우 해당 리스트에 추가

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (map.isEmpty()) {
                // Anagram 데이터가 비어있는 경우 추가.
                map.put(strs[i], new ArrayList<>(Collections.singletonList(strs[i])));
                continue;
            }

            boolean isAdded = false;
            for (String key : map.keySet()) {
                if (isAnagram(strs[i], key)) {
                    List<String> data = map.get(key);
                    data.add(strs[i]);
                    map.put(key, data);

                    isAdded = true;
                    break;
                }
            }

            if (!isAdded) {
                map.put(strs[i], new ArrayList<>(Collections.singletonList(strs[i])));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> data = map.get(key);
            result.add(data);
        }

        return result;
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < sArray.length; i++) {
            char sChar = sArray[i];
            char tChar = tArray[i];

            if (sChar != tChar) {
                return false;
            }
        }
        return true;
    }
}
