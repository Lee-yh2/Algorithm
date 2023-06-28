package algolithm.BOJ.shortestpath.백준4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int x, y, cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class 녹색옷입은애가젤다지 {
    static int n;
    static int[][] map;
    static int[][] dijk;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int cnt = 0;
        while (true){
            n = Integer.parseInt(br.readLine());

            if(n == 0) break;
            map = new int[n][n];
            dijk = new int[n][n];

            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dijk[i][j] = Integer.MAX_VALUE;
                }
            }
            int result = dijkstra();
            cnt++;
            sb.append("Problem "+ cnt + ": " + result).append("\n");
        }
        System.out.print(sb);

    }

    public static int dijkstra(){
        PriorityQueue<Node> pque = new PriorityQueue<>();

        dijk[0][0] = map[0][0];
        pque.add(new Node(0,0,map[0][0]));

        while (!pque.isEmpty()){
            Node node = pque.poll();

            for(int i = 0; i < 4; i++){
                int dX = node.x + dx[i];
                int dY = node.y + dy[i];

                if(dX < 0 || dX >= n || dY < 0 || dY >= n)
                    continue;

                if(dijk[dX][dY] > dijk[node.x][node.y] + map[dX][dY]){
                    dijk[dX][dY] = dijk[node.x][node.y] + map[dX][dY];
                    pque.add(new Node(dX, dY, dijk[dX][dY]));
                }
            }
        }
        return dijk[n-1][n-1];
    }
}
