package week9.LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by victory_woo on 2020/11/04
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    /*
     * 첫 번째 방법
     * map 에 다이얼에 맞도록 list 로 구성해서 문자들을 집어넣었음.
     * 그래서 index 별로 어떻게 따로 접근해서 해야할지 감이 안잡힘.
     * 23
     * 2 - ['a', 'b', 'c']
     * 3 - ['d', 'e', 'f']
     *
     * 2개에서 인덱스별로 어떻게 인덱스를 따로 관리할지, 최대 4개까지 나올 수 있는 각각 인덱스별로 관리하는게 말이 안됨.
     * */
    /*private static Map<Character, List<String>> map;
    private static int r;
    private static ArrayList<Combination> list;

    public static List<String> letterCombinations(String digits) {
        map = new HashMap<>();

        // map 초기화.
        init();
        r = digits.length(); // r개를 뽑을 것.
        list = new ArrayList<>();
        for (char digit : digits.toCharArray()) {
            System.out.println(map.get(digit));

            list.add(new Combination(digit, map.get(digit)));

        }

        return new ArrayList<>();
    }

    static class Combination {
        char key;
        List<String> list = new ArrayList<>();

        Combination(char key, List<String> list) {
            this.key = key;
            this.list.addAll(list);
        }
    }

    private static void init() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        map.put('2', list);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("d");
        list2.add("e");
        list2.add("f");
        map.put('3', list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("g");
        list3.add("h");
        list3.add("i");
        map.put('4', list3);

        ArrayList<String> list4 = new ArrayList<>();
        list4.add("j");
        list4.add("k");
        list4.add("l");
        map.put('5', list4);

        ArrayList<String> list5 = new ArrayList<>();
        list5.add("m");
        list5.add("n");
        list5.add("o");
        map.put('6', list5);

        ArrayList<String> list6 = new ArrayList<>();
        list6.add("p");
        list6.add("q");
        list6.add("r");
        list6.add("s");
        map.put('7', list6);

        ArrayList<String> list7 = new ArrayList<>();
        list7.add("t");
        list7.add("u");
        list7.add("v");
        map.put('8', list7);

        ArrayList<String> list8 = new ArrayList<>();
        list8.add("w");
        list8.add("x");
        list8.add("y");
        list8.add("z");
        map.put('9', list8);
    }*/


    /*
    * 두 번째 접근방법.
    * map 을 통해서 2-9 다이얼에 맞도록 문자열을 할당한다.
    * 백트래킹을 이용한다.
    * ex) digits = 23 이라면
    * 한글자씩 사용해서 map 에서 문자열을 꺼낸다.
    * abc 가 있고, 한글자씩 사용해서 그 다음 문자열을 붙인다.
    * a - [d,e,f]
    * b - [d,e,f]
    * c - [d,e,f]
    * 이런 식으로 진행하여 문자열을 붙이고 digit 의 길이가 0이라면 모든 조합의 경우를 구한 것이기 때문에
    * 결과 list 에 추가한다.
    * */
    private static Map<String, String> map;
    private static List<String> result;

    public static List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        result = new ArrayList<>();

        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "xwyz");

        if (digits.length() != 0) backtrack("", digits);

        return result;
    }

    private static void backtrack(String combination, String next_digit) {
        if (next_digit.length() == 0) result.add(combination);
        else {
            String digit = next_digit.substring(0, 1);
            String letters = map.get(digit);

            for (int i = 0; i < letters.length(); i++) {
                String letter = String.valueOf(letters.charAt(i));

                backtrack(combination + letter, next_digit.substring(1));
            }
        }
    }
}