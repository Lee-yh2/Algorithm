package algolithm.BOJ.graphtraversal.백준14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
    static int[][] map;
    static int n, m;
    static int safeZone = Integer.MIN_VALUE;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(safeZone);
    }

    static void dfs(int cntWall) {
        if (cntWall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cntWall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> que = new LinkedList<>();

        // 바이러스 시작 구간 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2)
                    que.offer(new Node(i, j));
            }
        }

        //원본은 안바뀌도록 copy하나 만들기
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        while (!que.isEmpty()) {
            Node virus = que.poll();

            for (int i = 0; i < 4; i++) {
                int x = virus.x + dirX[i];
                int y = virus.y + dirY[i];

                if (x < 0 || x >= n || y < 0 || y >= m)
                    continue;

                if (copyMap[x][y] == 0) {
                    que.offer(new Node(x, y));
                    copyMap[x][y] = 2;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0)
                    cnt++;
            }
        }

        safeZone = Math.max(cnt, safeZone);
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
