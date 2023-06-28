package algolithm.BOJ.graphtraversal.백준2178;

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

public class 미로탐색 {
    static int n, m, result = 0;
    static int[][] map;
    static boolean[][] isVisit;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.print(map[n-1][m-1]);
    }

    static void bfs(){
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(0, 0));
        isVisit[0][0] = true;
        while (!que.isEmpty()){
            Node node = que.poll();

            for(int i = 0; i < 4; i++){
                int dX = node.x + dirX[i];
                int dY = node.y + dirY[i];

                if (dX < 0 || dX >= n || dY < 0 || dY >= m)
                    continue;

                if(!isVisit[dX][dY] && map[dX][dY] != 0){
                    que.add(new Node(dX,dY));
                    isVisit[dX][dY] = true;
                    map[dX][dY] = map[node.x][node.y] + 1;
                }
            }
        }
    }
}
