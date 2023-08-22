package algolithm.programmers.random;

import java.util.ArrayList;
import java.util.List;

/**
 * 실패 (재귀) 7번 테스트케이스에서 계속 런타임에러
 */
public class 빛의경로사이클 {
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {-1, 0, 1, 0};
    static List<Integer> answer = new ArrayList<>();
    static boolean[][][] visited;

    public static void main(String[] args) {
        new 빛의경로사이클().solution(new String[]{"R","R"});
    }

    public int[] solution(String[] grid) {

        int row = grid.length;
        int col = grid[0].length();
        visited = new boolean[row][col][4];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k])
                        dfs(0, i, j, k, grid);
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    public void dfs(int depth, int curX, int curY, int dir, String[] grid) {
        if (visited[curX][curY][dir]) {
            answer.add(depth);
            return;
        }

        visited[curX][curY][dir] = true;
        int row = grid.length;
        int col = grid[0].length();

        if (grid[curX].charAt(curY) == 'L') {
            int d = (dir + 3) % 4;
            int nextX = (curX + dirX[d] + row) % row;
            int nextY = (curY + dirY[d] + col) % col;
            dfs(depth + 1, nextX, nextY, d, grid);
        } else if (grid[curX].charAt(curY) == 'R') {
            int d = (dir + 1) % 4;
            int nextX = (curX + dirX[d] + row) % row;
            int nextY = (curY + dirY[d] + col) % col;
            dfs(depth + 1, nextX, nextY, d, grid);
        } else {
            int nextX = (curX + dirX[dir] + row) % row;
            int nextY = (curY + dirY[dir] + col) % col;
            dfs(depth + 1, nextX, nextY, dir, grid);
        }

    }
}
