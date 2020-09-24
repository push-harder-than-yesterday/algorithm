// 문제: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/

import java.util.*;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "leetcode";
//        String s = "loveleetcode";
//        String s = "";
//        String s = "aadadaad";
        System.out.println("result: " + firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        // 첫번째 풀이
        // Set을 이용해 중복되지 않는 데이터를 저장한다.
        // 단, 하나인 characater 중 first를 반환해야 하므로 LinkedHashSet을 사용해
        // 순서를 유지시킨다.
        //  -> 통과는 되지만 Runtime 120ms로 매우 느리다..!
//        if (s != null && s.isEmpty()) return -1;
//        String[] splitS = s.split("");
//        if (splitS.length == 1) return 0;
//
//        int result = -1;
//        Set<String> data = new LinkedHashSet<>();
//        Set<String> already = new HashSet<>();
//        for (String str : splitS) {
//            if (data.contains(str)) {
//                data.remove(str);
//            } else {
//                if (!already.contains(str)) data.add(str); // 기존에 있던 애라면 단일 스트링으로 판단하지 않도록
//                already.add(str);
//            }
//        }
//
//        String target = null;
//        for (String str : data) {
//            target = str;
//            break;
//        }
//
//        for (int i = 0; i < splitS.length; i++) {
//            if (splitS[i].equals(target)) {
//                result = i;
//                break;
//            }
//        }
//        return result;

        // 두번째 풀이
        // Map을 이용해 각 글자의 갯수를 파악한다.
        int result = -1;
        Map<Character, Integer> data = new HashMap<>();
        for (char key : s.toCharArray()) {
            int value = data.getOrDefault(key, 0); // key에 밸류가 없을 때 Exception 방어
            data.put(key, value + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);

            if (data.get(key) == 1) {
                result = i;
                break;
            }
        }

        return result;
    }