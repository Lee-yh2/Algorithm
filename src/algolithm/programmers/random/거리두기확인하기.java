package algolithm.programmers.random;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302#fn1
 */
public class 거리두기확인하기 {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        for (int i = 0; i < places.length; i++){
            String[] p = places[i];

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(p[j].charAt(k) == 'P') {
                        answer[i] = bfs(j, k, p);

                        if(answer[i] == 0) break;
                    }
                }
                if(answer[i] == 0) break;
            }

        }

        return answer;
    }

    public int bfs(int sX, int sY, String[] p){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sX, sY});

        boolean[][] visited = new boolean[5][5];
        visited[sX][sY] = true;

        while (!q.isEmpty()){
            int[] pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = pos[0] + dirX[i];
                int nextY = pos[1] + dirY[i];

                if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5)
                    continue;

                if(visited[nextX][nextY])
                    continue;

                visited[nextX][nextY] = true;

                int m = Math.abs(nextX - sX) + Math.abs(nextY - sY);

                if(p[nextX].charAt(nextY) == 'P' && m <= 2)
                    return 0;
                else if(p[nextX].charAt(nextY) == 'O' && m < 2)
                    q.add(new int[]{nextX, nextY});
            }
        }

        return 1;
    }
}
