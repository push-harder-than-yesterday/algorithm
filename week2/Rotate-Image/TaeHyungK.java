package leetcode;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        // 첫번째 풀이
        // row와 column 을 대칭 시킨다음에 row 를 리버스 시키면 될듯
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }

        for (int i = 0; i < result.length; i++) {
            int left = 0;
            int right = result[i].length - 1;
            while (left < right) {
                int temp = result[i][left];
                result[i][left] = result[i][right];
                result[i][right] = temp;

                left++;
                right--;
            }
        }

        for (int i = 0; i < result.length; i++) {
            matrix[i] = Arrays.copyOf(result[i], result[i].length);
        }
    }
}
