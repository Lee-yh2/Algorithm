package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/17142
 */
public class 연구소3 {
    static int n, m, answer;
    static int zeroCnt;
    static int[][] map;
    static List<Point> virus;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        zeroCnt = 0;
        map = new int[n][n];
        answer = Integer.MAX_VALUE;
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    zeroCnt++;
                else if(map[i][j] == 2)
                    virus.add(new Point(i, j, 0));
            }
        }

        bt(0, 0, new int[m]);

        System.out.println((answer == Integer.MAX_VALUE)?-1:answer);
    }

    public static void bt(int depth, int start, int[] virusArr){
        if(depth == m){
            int ans = bfs(virusArr);
            if(ans != -1)
                answer = Math.min(ans, answer);

            return;
        }

        for (int i = start; i <virus.size(); i++) {
            virusArr[depth] = i;
            bt(depth+1, i+1, virusArr);
        }
    }

    public static int bfs(int[] virusArr){
        Queue<Point> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < virusArr.length; i++) {
            Point point = virus.get(virusArr[i]);
            isVisited[point.x][point.y] = true;
            q.add(point);
        }

        int ans = 0;
        int visitZeroCnt = 0;

        while (!q.isEmpty()){
            Point point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = point.x + dX[i];
                int nY = point.y + dY[i];

                if(nX < 0 || nX >= n || nY < 0 || nY >= n)
                    continue;

                if(isVisited[nX][nY])
                    continue;

                if(map[nX][nY] == 0){
                    visitZeroCnt++;
                    isVisited[nX][nY] = true;
                    ans = Math.max(ans, point.dis+1);
                    q.add(new Point(nX, nY, point.dis+1));
                } else if (map[nX][nY] == 2) {
                    isVisited[nX][nY] = true;
                    q.add(new Point(nX, nY, point.dis+1));
                }
            }
        }

        return (visitZeroCnt == zeroCnt)?ans:-1;
    }

    static class Point{
        int x;
        int y;
        int dis;

        public Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
