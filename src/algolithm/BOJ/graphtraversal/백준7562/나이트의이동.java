package algolithm.BOJ.graphtraversal.백준7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, cnt;

    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class 나이트의이동 {
    static StringBuilder sb = new StringBuilder();
    static boolean[][] isVisit;
    static Point end;
    static int l;

    static int[] rangeX = {-2,-2,2,2,-1,1,-1,1};
    static int[] rangeY = {-1,1,-1,1,-2,-2,2,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            l = Integer.parseInt(br.readLine());
            isVisit = new boolean[l][l];

            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point start = new Point(x, y, 0);


            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            end = new Point(x, y, 0);

            sb.append(bfs(start)).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(Point start){
        Queue<Point> que = new LinkedList<>();
        que.offer(start);

        isVisit[start.x][start.y] = true;
        while(!que.isEmpty()){
            Point point = que.poll();

            if(point.x == end.x && point.y == end.y)
                return point.cnt;

            for(int i = 0; i<8; i++){
                int dx = point.x + rangeX[i];
                int dy = point.y + rangeY[i];

                if(dx < 0 || dx >= l || dy <0 || dy >= l)
                    continue;

                if(!isVisit[dx][dy]){
                    isVisit[dx][dy] = true;
                    que.offer(new Point(dx,dy, point.cnt + 1));
                }
            }
        }
        return -1;
    }
}
