package leetcode;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        String word = "ABCCED";
        String word = "SEE";
//        String word = "ABCB";

        System.out.println("result: " + exist(board, word));
    }

    private static boolean[][] visited;
    private static boolean exist(char[][] board, String word) {
        // 아직 백트래킹에 대한 이해가 많이 부족한 것 같다.
        // 그래프 탐색처럼 상하좌우를 보는 것까진 이해가 갔는데
        // visited를 왜 다시 원상복귀 시키는지 정확히 이해가 안간다...
        // 알고리즘 푸는 사람들은 천재만 있나보다 .. 젠장..
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean search(char[][] board, String word, int depth, int i, int j) {
        if (word.length() == depth) {
            // 글자 수 만큼 잘 돈 경우
            return true;
        }
        if ((i < 0 || i >= board.length || j < 0 || j >= board[i].length) // 범위를 벗어나버린 경우
                || visited[i][j] // 방문했던 곳인 경우
                || word.charAt(depth) != board[i][j]) { // 글자가 맞지 않는 경우
            return false;
        }

        visited[i][j] = true;
        boolean result = search(board, word, depth + 1, i, j - 1) // 상
                || search(board, word, depth + 1, i, j + 1) // 하
                || search(board, word, depth + 1, i - 1, j) // 좌
                || search(board, word, depth + 1, i + 1, j); // 우
        visited[i][j] = false;
        return result;
    }
}
