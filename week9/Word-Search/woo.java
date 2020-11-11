package week9.WordSearch;

/**
 * created by victory_woo on 2020/11/04
 */
public class woo {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
        //System.out.println(exist(board, "SEE"));
        //System.out.println(exist(board, "ABCB"));
    }

    /*
     * 첫 번째 접근 방법.
     * 백트래킹으로 풀었지만, 내부적으로 백트래킹으로 동작하지 않는다.
     * 제일 취약한 부분이라,, 역시나 어렵다..
     * */

    /*private static char[][] map;
    private static boolean[] visited;
    private static int row, col;

    public static boolean exist(char[][] board, String word) {
        map = board;
        visited = new boolean[word.length()];
        char start = word.charAt(0);

        row = board.length;
        col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == start) {
                    visited[0] = true;
                    find(i, j, word, 1);
                }
            }
        }
        return flag;
    }

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean flag = false;

    private static void find(int x, int y, String word, int index) {
        if (index == word.length()) {
            if (check()) flag = true;

            return;
        }

        if (flag) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
            if (visited[index]) continue;


            if (map[nx][ny] == word.charAt(index)) {
                System.out.println(map[nx][ny]);
                visited[index] = true;
                find(nx, ny, word, index + 1);
            }

        }

        visited[index] = false;
    }

    private static boolean check() {
        for (boolean flag : visited) {
            if (!flag) return false;
        }

        return true;
    }*/


    /*
    * 두 번째 접근 방법.
    * 백트래킹을 이용한다.
    * 첫 번째 방법과 유사하지만, find() 함수에서 세부적으로 조건을 검사하는 부분이 다르다.
    * 그리고 find() 함수가 boolean 을 반환하고, 계속해서 재귀 호출이 이루어지는 부분도 다르다.
    *
    * 범위를 벗어나거나 이미 방문한 적이 있거나, 확인하려는 문자와 정점의 문자가 다른 경우에는 false.
    * 위의 조건에서 걸리지 않는다면 해당 정점에 방문했음을 표시한다.
    * 그리고 index 가 문자열의 끝까지 도달했다면, 모든 문자를 검사했는데 이상이 없으므로 word 를 찾을 수 있다는 것을 뜻하며 true.
    * index 를 증가시켜줘야 다음 문자를 확인할 수 있다.
    * for 문을 돌면서 상,하,좌,우 네 방향을 모두 검사한다.
    * 확인했을 때, 다음에 확인할 문자가 있다면 계속해서 true 를 반환하며 find 를 하다가
    * 위에서 index 가 word 의 끝에 도달하면 끝남으로써 true 반환.
    *
    * 한번에 쭉 찾지 못할 경우도 존재하기 때문에 백트래킹을 통해서 이전 단계로 돌아가서 원래대로 되돌리고, 다른 경우를 찾아야 한다.
    * */
    private static boolean[][] visited;
    private static int r, c;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;

        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (find(i, j, 0, word, board)) return true;
            }
        }
        return false;
    }

    private static boolean find(int row, int col, int index, String word, char[][] board) {
        // 범위를 벗어나거나 이미 방문했거나 해당 공간의 문자와 다를 경우, false.
        if (!isOutOfRange(row, col) || visited[row][col] || board[row][col] != word.charAt(index)) return false;

        // 해당 정점은 방문했음을 표시한다.
        visited[row][col] = true;

        // index 가 word 의 끝까지 도달했다면, word 단어를 만들 수 있는 경우이므로 true 반환.
        if (index == word.length() - 1) return true;

        // index 를 증가시켜줌으로써 다음 문자를 확인한다.
        index++;

        // 현재 정점에서 상,하,좌,우를 확인한다.
        // 확인했을 때, 다음에 확인할 문자가 있다면 계속해서 true 를 반환하며 find 를 하다가
        // 위에서 index 가 word 의 끝에 도달하여 끝남으로써 true 를 반환한다.
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if (find(nextRow, nextCol, index, word, board)) return true;
        }

        // 백트래킹으로 체크했던 정점을 원래대로 되돌린다.
        visited[row][col] = false;

        // 여기까지 왔을 경우에는 찾지 못한 경우이다.
        return false;
    }


    private static boolean isOutOfRange(int row, int col) {
        return row >= 0 && col >= 0 && row < r && col < c;
    }
}
