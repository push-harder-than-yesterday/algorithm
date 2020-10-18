package week6.SetMatrixZeroes;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/10/12
 */
public class woo {
    public static void main(String[] args) {
        setZeroes(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        });
        setZeroes(new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        });
    }

    private static int row;
    private static int col;

    public static void setZeroes(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;

        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) list.add(new Node(i, j));
            }
        }

        for (Node node : list) setZero(node.x, node.y, matrix);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZero(int x, int y, int[][] matrix) {
        // 오른쪽.
        if (y + 1 < col) {
            for (int c = y + 1; c < col; c++) {
                if (matrix[x][c] == 0) continue;
                matrix[x][c] = 0;
            }
        }

        // 왼쪽.
        if (0 <= y - 1) {
            for (int c = y - 1; c >= 0; c--) {
                if (matrix[x][c] == 0) continue;
                matrix[x][c] = 0;
            }
        }

        // 아래쪽.
        if (x + 1 < row) {
            for (int r = x + 1; r < row; r++) {
                if (matrix[r][y] == 0) continue;
                matrix[r][y] = 0;
            }
        }

        // 위쪽.
        if (0 <= x - 1) {
            for (int r = x - 1; r >= 0; r--) {
                if (matrix[r][y] == 0) continue;
                matrix[r][y] = 0;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
