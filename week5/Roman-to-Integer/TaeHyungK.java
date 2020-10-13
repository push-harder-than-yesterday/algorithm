package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "IV";

        System.out.println(romanToInt(s));
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;

        int before = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curInt = roman.get(s.charAt(i));

            if (curInt < before) {
                result += -curInt;
            } else {
                result += curInt;
            }

            before = curInt;
        }
        return result;
    }
}
