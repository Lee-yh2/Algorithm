package algolithm.BOJ.graphtraversal.백준2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 영역구하기 {
    static int m, n, k;
    static int[][] map;
    static ArrayList<Integer> list = new ArrayList<>();

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = y1; x < y2; x++) {
                for (int y = x1; y < x2; y++) {
                    map[x][y]++;
                }
            }
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (map[x][y] == 0) {
                    bfs(x, y);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int a : list)
            sb.append(a).append(" ");
        System.out.print(sb);

    }

    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(x, y));
        map[x][y]++;
        int cnt = 1;
        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int dX = cur.x + dirX[i];
                int dY = cur.y + dirY[i];

                if (dX < 0 || dX >= m || dY < 0 || dY >= n)
                    continue;
                if (map[dX][dY] == 0) {
                    que.add(new Node(dX, dY));
                    map[dX][dY]++;
                    cnt++;
                }
            }
        }
        list.add(cnt);
    }
}
