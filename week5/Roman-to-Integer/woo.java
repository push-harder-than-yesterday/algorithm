package week5.RomanToInteger;

import java.util.HashMap;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo2 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("MDCXCV"));
    }

    /*
    * 처음 접근 방법
    * 알파벳별로 정해진 정수 값이 있다. 따라서 HashMap에 미리 저장해준다.
    * 그리고 점수별로 list에 다시 저장해준다. (왜 이렇게 했는지는 모르겠다... 사실, 바로 map에서 꺼내와도 되는데, 이렇게 했었다.)
    * 그리고 2개씩 비교하며 값을 누적한다.
    * a, b라고 할때,
    * a < b인 경우, [b - a]를 더해준다. 그리고 i+=2
    * a ≥ b인 경우, a를 더해준다. 그리고 i++
    * 반복문을 나왔을 때, 더해주지 못한 값이 남아있기 때문에 b 값을 누적해준다.
    * 여기서 잘못 생각했던 부분은 2개를 비교하면, 그 2개를 건너뛴 다음 2개에 대해서 처리하는 것이라 생각하였다. 그게 아니라 바로 이전과 비교하며 하나씩 증가해서 비교하고 값을 처리하는 것이었다.
    * 즉, i++만 해도 되는 것이었다.
    * */
    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        ArrayList<Integer> list = new ArrayList<>();
        for (String word : s.split("")) {
            list.add(map.get(word));
        }

        System.out.println(list);
        int i = 0;
        int sum = 0;
        int a = 0, b = 0;
        boolean flag = false;
        while (i < list.size() - 1) {
            a = list.get(i);
            b = list.get(i + 1);

            if (a < b) {
                flag = false;
                sum += (b - a);
                i += 2;
            } else {
                flag = true;
                sum += a;
                i++;
            }
        }

        if (flag) sum += b;

        return sum;
    }


    /*
    * 2개씩 차례대로 비교해나간다.
    * 하나씩 다음 단계에서 비교한다.
    * prev < cur -> 누적합 sum 에서 prev 를 빼준다.
    * prev >= cur -> 누적합 sum 에 prev 를 더해준다.
    *
    * 반복문을 다 돌고 나오면 마지막 원소는 누적되지 않으므로 sum += prev.
    * */
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int prev = map.get(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));

            if (prev < cur) sum -= prev;
            else sum += prev;

            prev = cur;
        }

        sum += prev;
        return sum;
    }
}
