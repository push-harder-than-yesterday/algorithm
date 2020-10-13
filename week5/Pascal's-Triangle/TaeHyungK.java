package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;

        System.out.println("result: " + generate(numRows));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);

        for (int i = 1; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            List<Integer> beforeList = result.get(i - 1);

            item.add(1);
            for (int j = 1; j < i; j++) {
                item.add(beforeList.get(j - 1) + beforeList.get(j));
            }
            item.add(1);

            result.add(item);
        }

        return result;
    }
}
