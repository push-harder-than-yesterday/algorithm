package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1},
                {1, 1, 1},
                {1, 0, 1}};
        setZeroes(matrix);
    }

    private static void setZeroes(int[][] matrix) {
        // 첫번째 풀이
        // 1. 원본 배열에서의 0의 좌표를 찾는다.
        // 2. 해당 배열을 기준으로 행,열을 0으로 바꾼다.
        // -> 3중 포문... 좋지 못하다.. O(N^2 + N^3)..
        List<int[]> zeroXY = new ArrayList<>();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if (matrix[x][y] == 0) {
                    zeroXY.add(new int[]{x, y});

                }
            }
        }

        for (int[] xy : zeroXY) {
            System.out.println(Arrays.toString(xy));

            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == x || j == y) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
