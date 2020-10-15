package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzz(n));
    }

    private static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                // 3과 5의 배수인 경우
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                // 3의 배수인 경우
                list.add("Fizz");
            } else if (i % 5 == 0) {
                // 5의 배수인 경우
                list.add("Buzz");
            } else {
                // 아무것도 아닌 경우
                list.add(String.valueOf(i));
            }
        }

        return list;
    }
}
