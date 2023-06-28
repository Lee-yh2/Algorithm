package algolithm.BOJ.graphtraversal.백준1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 음식물피하기 {
    static int[][] list;
    static int n, m, result = 0;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        list = new int[n][m];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            list[r][c] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i][j] == 1)
                    bfs(i, j);
            }
        }

        System.out.print(result);
    }

    static void bfs(int r, int c) {
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(r, c));
        list[r][c] = 2;
        int cnt = 1;
        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int dX = node.x + dirX[i];
                int dY = node.y + dirY[i];

                if (dX < 0 || dX >= n || dY < 0 || dY >= m)
                    continue;

                if (list[dX][dY] == 1) {
                    que.add(new Node(dX, dY));
                    list[dX][dY] = 2;
                    cnt++;
                }
            }
        }
        result = Math.max(result, cnt);
    }
}
