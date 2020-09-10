import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
//        int[] digits = {1,2,3};
//        int[] digits = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
//        int[] digits = {9};
        int[] digits = {8,9,9};
//        int[] digits = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
        int[] result = plusOne(digits);
        System.out.println("result");
        for (int num : result) {
            System.out.print(num + ",");
        }
    }

    public static int[] plusOne(int[] digits) {
        // 첫번째 풀이
        // digits 배열을 int type으로 바꾼 후 + 1해주고 다시 배열로 분해한다.

        // 두번째 풀이
        // 맨처음 digits 배열을 int type으로 바꾸면 int 사이즈를 넘어가는 케이스가 생겨 실패한다.
        // 해서 long 타입을 사용해야 한다.
//        long data = 0;
//
//        int j = 0;
//        for (int i = digits.length - 1; i >= 0; i--) {
//            long num = digits[j];
//            long base = (int) Math.pow(10, i);
//            System.out.println(num + " | " + base);
//            data += num * base;
//
//            j++;
//        }
//        data++;
//        System.out.println(data);
//
//        // 자릿수 구하기
//        int size = 0;
//        long temp = data;
//        while (temp != 0) {
//            temp /= 10;
//            size++;
//        }
//        System.out.println(size);
//
//        int[] result = new int[size];
//        for (int i = size - 1; i >= 0; i--) {
//            result[i] = (int) (data % 10);
//            data /= 10;
//        }
//        return result;

        // 세번째 풀이
        // 예시 중에 long 타입의 범위도 넘어가는 케이스도 있다.
        // 스트링으로 변환해서 해야 할듯 하다.
        // 이렇게 해도 parse 할 때 long 타입을 넘으면 Exception 발생한다.
//        String input = Arrays.toString(digits).replaceAll("[^0-9]", "");
//
//        String addResult = String.valueOf(Long.parseLong(input) + 1);
//        String[] temp = addResult.split("");
//        int[] result = new int[temp.length];
//        for (int i = 0; i < temp.length; i++) {
//            result[i] = Integer.parseInt(temp[i]);
//        }
//
//        return result;

        // 네번째 풀이
        // 배열의 역순으로(사람이 숫자 더하듯이) +1을 더하고 10이 넘을 경우 해당 위치는 0을 넣고 앞에 애한테 +1을 넘겨준다.
        // 반복하면 List 에는 거꾸로 숫자가 들어가있을 것이다.
        // 이것을 다시 원래대로 하기 위해 reverse 해준 후 해당 값을 배열로 변환시키면 된다.

        List<Integer> data = new ArrayList<>();
        boolean isOver = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                if (++digits[i] >= 10) {
                    data.add(0);
                    isOver = true;
                } else {
                    data.add(digits[i]);
                    isOver = false;
                }
                continue;
            }

            if (isOver) {
                if (++digits[i] >= 10) {
                    data.add(0);
                    isOver = true;
                } else {
                    data.add(digits[i]);
                    isOver = false;
                }
            } else {
                data.add(digits[i]);
            }
        }
        if (isOver) {
            data.add(1);
        }

        Collections.reverse(data);
        int[] result = new int[data.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = data.get(i);
        }

        return result;
    }
}