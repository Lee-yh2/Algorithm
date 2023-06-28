package algolithm.BOJ.graphtraversal.백준2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1은 집 o
 * 0은 집 x
 */
class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 단지번호붙이기 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> houseCnt = new ArrayList<>();
    static int[][] map;
    static int n, houseComplex = 0;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    bfs(i, j);
                    houseComplex++;
                }
            }
        }
        Collections.sort(houseCnt);
        sb.append(houseComplex).append("\n");
        for(int a: houseCnt)
            sb.append(a).append("\n");

        System.out.print(sb);
    }

    static void bfs(int a, int b) {
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(a, b));
        map[a][b] = 2;
        int cnt = 0;
        while (!que.isEmpty()) {
            Node node = que.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int dX = node.x + dirX[i];
                int dY = node.y + dirY[i];

                if (dX < 0 || dX >= n || dY < 0 || dY >= n)
                    continue;

                if (map[dX][dY] == 1) {
                    que.add(new Node(dX, dY));
                    map[dX][dY] = 2;
                }
            }
        }

        houseCnt.add(cnt);
    }
}
