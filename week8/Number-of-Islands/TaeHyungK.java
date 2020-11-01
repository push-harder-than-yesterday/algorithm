package leetcode;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println("result: " + numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        // 트리 형태 + 우측은 linked 로 연결하면 될 거라 생각했는데 어떻게 해야할지 모르겠다...
        // https://gamjatwigim.tistory.com/146 <- 참고
        // bfs 로 문제를 풀어야 했다.

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') { // 먼저 1을 찾는다.
                    bfs(grid, i, j); // 붙어있는 1들을 찾는다.
                    result++;
                }
            }
        }

        return result;
    }

    private static void bfs(char[][] grid, int row, int col) {
        grid[row][col] = '-'; // 찾은 붙어있는 1은 1이 아닌 다른 문제로 변경

        if (row < grid.length - 1 && grid[row + 1][col] == '1') {
            // 위를 찾는 조건
            bfs(grid, row + 1, col);
        }
        if (row > 0 && grid[row - 1][col] == '1') {
            // 아래를 찾는 조건
            bfs(grid, row - 1, col);
        }
        if (col > 0 && grid[row][col - 1] == '1') {
            // 왼쪽을 찾는 조건
            bfs(grid, row, col - 1);
        }
        if (col < grid[row].length - 1 && grid[row][col + 1] == '1') {
            // 오른쪽을 찾는 조건
            bfs(grid, row, col + 1);
        }
    }
}
