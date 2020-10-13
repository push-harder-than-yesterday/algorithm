package week5.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * created by victory_woo on 2020/10/09
 */
public class woo {
    public static void main(String[] args) {
        generate(6);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            int[] arr = new int[i];
            arr[0] = arr[i - 1] = 1;

            if (3 <= i) {
                for (int j = 1; j < i - 1; j++) {
                    List<Integer> row = result.get(i - 2);
                    arr[j] = row.get(j - 1) + row.get(j);
                }
            }
            List<Integer> subList = new ArrayList<>();
            for (int v : arr) subList.add(v);

            result.add(subList);
        }

        print(result);

        return result;
    }

    private static void print(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            for (int v : list) System.out.print(v + " ");
            System.out.println();
        }
    }
}
