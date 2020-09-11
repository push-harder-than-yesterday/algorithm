package leetcode;

import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
//        char[][] board = new char[][]{
//                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        }
        System.out.println("result: " + isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        // 첫번째 풀이
        // row 별로 체크
        // column 별로 체크
        // 3x3 box 별로 체크
        // Set을 이용해서 중복된 값이 발생한 경우 바로 false 반환
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowTemp = new HashSet<>();
            Set<Character> columnTemp = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                // row 별 유효 체크
                if (board[i][j] != '.' && rowTemp.contains(board[i][j])) {
                    return false;
                }
                rowTemp.add(board[i][j]);

                // column 별 유효 체크
                if (board[j][i] != '.' && columnTemp.contains(board[j][i])) {
                    return false;
                }
                columnTemp.add(board[j][i]);
            }
        }

        // 3x3 별 유효 체크
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                if (!isValid3x3Box(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid3x3Box(char[][] board, int startX, int startY) {
        char[][] box = new char[3][3];
        Set<Character> boxTemp = new HashSet<>();
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                if (board[startX + i][startY + j] != '.' && boxTemp.contains(board[startX + i][startY + j])) {
                    return false;
                }
                boxTemp.add(board[startX + i][startY + j]);
            }
        }
        return true;
    }
}