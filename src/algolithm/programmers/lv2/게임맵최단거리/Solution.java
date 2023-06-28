package algolithm.programmers.lv2.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int n, m;
    int[][] isVisit;

    int[] dirX = {-1,1,0,0};
    int[] dirY = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;

        isVisit = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(maps[i][j] == 0)
                    isVisit[i][j] = -1;
            }
        }

        bfs();

        answer = isVisit[n-1][m-1] == 0?-1:isVisit[n-1][m-1];

        return answer;
    }

    public void bfs(){
        Queue<Point> que = new LinkedList<>();

        que.add(new Point(0, 0));
        isVisit[0][0] = 1;

        while (!que.isEmpty()){
            Point cur = que.poll();

            for (int i = 0; i <4 ; i++) {
                int dX = cur.x + dirX[i];
                int dY = cur.y + dirY[i];

                if(dX < 0 || dY < 0 || dX >= n || dY >= m)
                    continue;

                if(isVisit[dX][dY] == 0){
                    que.add(new Point(dX,dY));
                    isVisit[dX][dY] = isVisit[cur.x][cur.y]+1;
                }
            }
        }
    }

    class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
