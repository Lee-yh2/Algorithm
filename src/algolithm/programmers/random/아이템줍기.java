package algolithm.programmers.random;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {
    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};
    static int[][] map;
    static int answer;

    public static void main(String[] args) {
        int[][] rectangle = new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        solution(rectangle, 1,3,7,8);
    }
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = Integer.MAX_VALUE;

        map = new int[101][101];

        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    if(map[j][k] == 2) continue;
                    map[j][k] = 2;
                    if(j == x1 || j == x2 || k == y1 || k == y2)
                        map[j][k] = 1;
                }
            }
        }

        bfs(characterX*2, characterY*2, itemX*2, itemY*2);

        return answer/2;
    }

    public static void bfs(int sX, int sY, int itemX, int itemY){
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sX, sY});

        while (!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == itemX && cur[1] == itemY) {
                answer = map[cur[0]][cur[1]];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if(nextX < 0 || nextX > 100 || nextY < 0 || nextY > 100)
                    continue;

                if(visited[nextX][nextY] || map[nextX][nextY] != 1)
                    continue;

                map[nextX][nextY] = map[cur[0]][cur[1]]+1;

//                if(nextX == itemX && nextY == itemY){
//                    answer = Math.min(answer, map[nextX][nextY]);
//                    continue;
//                }
                visited[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY});
            }
        }
    }
}
