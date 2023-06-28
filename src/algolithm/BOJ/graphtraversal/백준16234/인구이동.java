package algolithm.BOJ.graphtraversal.백준16234;

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

public class 인구이동 {
    static int n, l, r;
    static int[][] map;
    static boolean[][] isVisit;
    static ArrayList<Node> list = new ArrayList<>();

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        isVisit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(isVisit[i], false);
            }

            boolean tryMigration = false; //인구이동 했나 확인 변수
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!isVisit[i][j]) {
                        bfs(i, j);
                        if (list.size() > 1) {
                            migration(); //인구 이동시키는 함수
                            tryMigration = true;
                        } else
                            list.clear();
                    }
                }
            }
            if (tryMigration)
                result++;
            else
                break;
        }

        System.out.println(result);
    }

    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(x, y));
        isVisit[x][y] = true;
        list.add(new Node(x, y));
        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int dX = node.x + dirX[i];
                int dY = node.y + dirY[i];

                if (dX < 0 || dX >= n || dY < 0 || dY >= n)
                    continue;

                Node nod = new Node(dX, dY);
                if (!isVisit[dX][dY] && openCheck(node, nod)) {
                    que.add(nod);
                    isVisit[dX][dY] = true;
                    list.add(nod);
                }
            }
        }
    }

    static boolean openCheck(Node n1, Node n2) {
        int cal = Math.abs(map[n1.x][n1.y] - map[n2.x][n2.y]);
        if (cal >= l && cal <= r)
            return true;
        return false;
    }

    static void migration() {
        int sum = 0;
        for (Node node : list) {
            sum += map[node.x][node.y];
        }

        for (Node node : list) {
            map[node.x][node.y] = sum / list.size();
        }

        list.clear();
    }
}
