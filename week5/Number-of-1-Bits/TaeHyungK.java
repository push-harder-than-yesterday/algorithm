package leetcode;

public class NumberOf1Bits {
    public static void main(String[] args) {
        // 3210
        // 8 2 1 = 11
        int n = 00000000000000000000000000001011;

        System.out.println("result: " + hammingWeight(n));
    }

    // you need to treat n as an unsigned value
    private static int hammingWeight(int n) {
        int size = 0;

        // 첫번째 풀이
        // 10진수를 2진수로 변경한 후 1의 갯수를 센다.
        // 이유를 모르겠는데 위의 예시처럼 할 경우 IDE 에서는 16진수로 인식이 된다. 왜지?
        // leetcode IDE 에서는 정상적으로 읽어오기 때문에 하기 코드는 web IDE를 기준으로 작성
        String str = Integer.toBinaryString(n);

        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (item == '1') size++;
        }

        return size;
    }
}
