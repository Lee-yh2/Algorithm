package algolithm.BOJ.backtracking.백준10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회2 {
    static int n, result = Integer.MAX_VALUE;
    static int[][] road;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        road = new int[n][n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            visited[i] = true;
            bf(0, i, i, 0);
            visited[i] = false;
        }
        System.out.println(result);

    }

    static void bf(int depth, int start, int cur, int cost){
        if(depth == n-1){
            if(road[cur][start] != 0){
                cost += road[cur][start];
                result = Math.min(cost, result);
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i] && road[cur][i] != 0){
                visited[i] = true;
                bf(depth+1, start, i, cost + road[cur][i]);
                visited[i] = false;
            }
        }
    }
}
