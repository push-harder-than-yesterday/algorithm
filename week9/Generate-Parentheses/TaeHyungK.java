package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;

        System.out.println("result: " + generateParenthesis(n));
    }

    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // 어떻게 풀어야하는지 전혀 감도 안왔다..
        // 솔루션을 보니 재귀를 통해 푸는 문제였다.
        // 다만, 승우님이랑 비교해봤을 때 StringBuilder 사용의 차이인데
        // sb에서는 왜 맨 뒷글자를 제거해주어야 정상적으로 되는지 이해가 잘 가지 않는다.
        // 코드를 이해하기로는 승우님 코드가 더 깔끔해 보인다.
        makeParenthesis(0, 0, new StringBuilder(), n, result);
        return result;
    }

    private static void makeParenthesis(int left, int right, StringBuilder sb, int n, List<String> result) {
        if(left == n && right == n) {
            result.add(sb.toString());
            return;
        }

        if(left < n) {
            sb.append("(");
            makeParenthesis(left + 1, right, sb, n, result);
            sb.deleteCharAt(sb.length() - 1); // 맨 뒷글자 제거
        }

        if(right < left) {
            sb.append(")");
            makeParenthesis(left, right + 1, sb, n, result);
            sb.deleteCharAt(sb.length() - 1); // 맨 뒷글자 제거
        }
    }
}
