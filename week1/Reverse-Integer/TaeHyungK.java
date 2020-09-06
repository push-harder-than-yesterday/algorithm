// 문제: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/

public class ReverseInteger {
    public static void main(String[] args) {
//        int x = 123;
//        int x = -123;
        int x = 120;
        System.out.println("result: " + reverse(x));
    }

    public static int reverse(int x) {
        // 첫번째 풀이
        // String 배열로 만들고 그 배열을 뒤집은 후 다시 인트로 형 변환
        // -> 이거 매우 효율적이지 못해서 나중에 다시 한번 풀어봐야 할 듯..!
        int result = 0;
        String[] splitX = String.valueOf(x).split("");
        boolean isNegaitve = false;
        if ("-".equals(splitX[0])) {
            // 기호인 경우
            isNegaitve = true;
        }

        StringBuilder strBuilder = new StringBuilder();
        int lastIdx = isNegaitve ? 1 : 0;
        for (int i = splitX.length - 1; i >= lastIdx; i--) {
            System.out.println(splitX[i]);
            strBuilder.append(splitX[i]);
        }

        System.out.println(strBuilder.toString());
        try {
            result = isNegaitve ? -Integer.parseInt(strBuilder.toString()) : Integer.parseInt(strBuilder.toString());
        } catch (Exception e) {
            result = 0;
        }

        return result;
    }
}
