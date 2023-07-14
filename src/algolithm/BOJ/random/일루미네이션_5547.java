package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  1  2  3  4  5  6  7  8
 *  9  10 11 12 13 14 15 16
 *  17 18 19 20 21 22 23 24
 *  25 26 27 28 29 30 31 32
 */
public class 일루미네이션_5547 {
    static int map[][];
    static boolean visited[][];
    static int[] oddX = {-1, -1, 0, 1, 1, 0};
    static int[] oddY = {0, 1, 1, 1, 0, -1};
    static int[] evenX = {-1, -1, 0, 1, 1, 0};
    static int[] evenY = {-1, 0, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[m+2][n+2];
        visited = new boolean[m+2][n+2];

        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(n, m);
        int result = wallLength(n, m);
        System.out.println(result);
    }

    static void bfs(int n, int m){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int dX, dY;
                if(cur.x % 2 == 0){
                    dX = cur.x + evenX[i];
                    dY = cur.y + evenY[i];
                }else{
                    dX = cur.x + oddX[i];
                    dY = cur.y + oddY[i];
                }

                if(dX < 0 || dY < 0 || dX > m+1 || dY > n+1)
                    continue;

                if(visited[dX][dY])
                    continue;

                if(map[dX][dY] == 0){
                    visited[dX][dY] = true;
                    q.add(new Node(dX, dY));
                }
            }
        }
    }

    static int wallLength(int n, int m){
        int length = 0;
        for (int i = 0; i < m+2; i++) {
            for (int j = 0; j < n+2; j++) {
                if (!visited[i][j] || map[i][j] == 1)
                    continue;
                for (int k = 0; k < 6; k++) {
                    int dX, dY;
                    if (i % 2 == 0) {
                        dX = i + evenX[k];
                        dY = j + evenY[k];
                    } else {
                        dX = i + oddX[k];
                        dY = j + oddY[k];
                    }

                    if (dX < 0 || dY < 0 || dX > m + 1 || dY > n + 1)
                        continue;

                    if (!visited[dX][dY] && map[dX][dY] == 1)
                        length++;
                }
            }
        }

        return length;
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
