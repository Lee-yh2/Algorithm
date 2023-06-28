package algolithm.programmers.lv2.카카오프렌즈컬러링북;

import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 카카오프렌즈컬러링북 {
    static int[][] isVisit;

    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        isVisit = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 0)
                    isVisit[i][j] = 1;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isVisit[i][j] == 0) {
                    maxSizeOfOneArea = Math.max(bfs(m,n,picture,i,j),
                            maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(int m, int n, int[][] picture, int sX, int sY){
        int cnt = 1;
        Queue<Point> que = new LinkedList<>();

        que.add(new Point(sX, sY));
        isVisit[sX][sY] = 1;
        while (!que.isEmpty()){
            Point point = que.poll();

            for(int i = 0; i < 4; i++){
                int dX = point.x + dirX[i];
                int dY = point.y + dirY[i];

                if(dX < 0 || dY < 0 || dX >= m || dY >= n)
                    continue;

                if(picture[point.x][point.y] == picture[dX][dY]
                        && isVisit[dX][dY] == 0){
                    que.add(new Point(dX, dY));
                    isVisit[dX][dY] = 1;
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
