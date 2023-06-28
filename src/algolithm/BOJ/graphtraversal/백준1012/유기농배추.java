package algolithm.BOJ.graphtraversal.백준1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 시간복잡도 O(n*m)
 */
class Node{
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 유기농배추 {
    static StringBuilder sb = new StringBuilder();
    static int n, m, k;
    static int[][] list;

    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            list = new int[m][n];

            int cnt = 0;

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a][b] = 1;
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(list[i][j] == 1){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y){
        Queue<Node> que = new LinkedList<>();

        list[x][y] = 2;
        que.offer(new Node(x, y));
        while (!que.isEmpty()){
            Node node = que.poll();

            for(int i = 0; i < 4; i++){
                int dX = node.x + dirX[i];
                int dY = node.y + dirY[i];

                if(dX < 0 || dX >= m || dY < 0 || dY >= n)
                    continue;

                if(list[dX][dY] == 1){
                    que.offer(new Node(dX, dY));
                    list[dX][dY] = 2;
                }
            }
        }
    }
}
