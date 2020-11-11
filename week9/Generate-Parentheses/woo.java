package week9.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * created by victory_woo on 2020/11/04
 */
public class woo {
    public static void main(String[] args) {
        //System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(8));
        /*System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(1));*/
    }

    /*
     * 첫 번째 접근방법.
     * 재귀 호출.
     * */
    /*private static ArrayList<String> result;

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        solve("", n, 0);

        return result;
    }

    private static void solve(String parentheses, int n, int count) {
        if (count == n * n) {
            if (check(parentheses)) result.add(parentheses);

            return;
        }

        solve(parentheses + "(", n, count + 1);
        solve(parentheses + ")", n, count + 1);
    }

    // 괄호가 올바른 괄호인지 체크한다.
    private static boolean check(String parentheses) {
        int count = 0;
        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(') count++;
            else count--;

            if (count < 0) return false;
        }
        return count == 0;
    }*/

    private static ArrayList<String> result;

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        solve("", n, 0, 0);

        return result;
    }

    private static void solve(String parentheses, int n, int leftCount, int rightCount) {
        if (leftCount == rightCount && n == leftCount) {
            if (check(parentheses)) result.add(parentheses);

            return;
        }

        if (leftCount < n) solve(parentheses + "(", n, leftCount + 1, rightCount);
        if (rightCount < n) solve(parentheses + ")", n, leftCount, rightCount + 1);
    }

    // 괄호가 올바른 괄호인지 체크한다.
    private static boolean check(String parentheses) {
        int count = 0;
        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(') count++;
            else count--;

            if (count < 0) return false;
        }
        return count == 0;
    }
}
