package algolithm.programmers.random;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86052
 */

public class 빛의경로사이클_성공 {
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {-1, 0, 1, 0};
    static List<Integer> answer = new ArrayList<>();
    static boolean[][][] visited;

    public int[] solution(String[] grid) {

        int row = grid.length;
        int col = grid[0].length();
        visited = new boolean[row][col][4];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k])
                        cycleCheck(i, j, k, grid, row, col);
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    public void cycleCheck(int x, int y, int dir, String[] grid, int row, int col){
        int cnt = 0;

        while (!visited[x][y][dir]){
            visited[x][y][dir] = true;
            cnt++;

            if (grid[x].charAt(y) == 'L') {
                dir = (dir + 3) % 4;
            } else if (grid[x].charAt(y) == 'R') {
                dir = (dir + 1) % 4;
            }

            x = (x + dirX[dir] + row) % row;
            y = (y + dirY[dir] + col) % col;
        }

        answer.add(cnt);
    }
}
