package leetcode;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";

        System.out.println("result: " + letterCombinations(digits));
    }

    private static final Map<String, String[]> keypad = new HashMap<>();
    static {
        keypad.put("2", new String[]{"a", "b", "c"});
        keypad.put("3", new String[]{"d", "e", "f"});
        keypad.put("4", new String[]{"g", "h", "i"});
        keypad.put("5", new String[]{"j", "k", "l"});
        keypad.put("6", new String[]{"m", "n", "o"});
        keypad.put("7", new String[]{"p", "q", "r", "s"});
        keypad.put("8", new String[]{"t", "u", "v"});
        keypad.put("9", new String[]{"w", "x", "y", "z"});
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        String[] splitData = digits.split("");
        // 첫번째 풀이
        // BFS로 모든 값 순회하면 될 거라 생각했는데 어떻게 하는지 몰라 구글링했다..
        Queue<String> queue = new ArrayDeque<>();
        String[] items = keypad.get(splitData[0]);
        for (int i = 0; i < items.length; i++) {
            // queue가 비어있으면 순회가 안돼서 처음에는 그냥 넣어줌
            // 첫 문자에 대한 스트링들을 넣어줌
            queue.offer(items[i]);
        }

        int size = 0;
        for (int i = 1; i < digits.length(); i++) {
            items = keypad.get(splitData[i]);
            size = queue.size();
            for (int j = 0; j < size; j++) {
                String data = queue.poll();
                for (int k = 0; k < items.length; k++) {
                    // 기존 문자 + 새로운 데이터에 대한 문자 조합
                    queue.offer(data + items[k]);
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}
