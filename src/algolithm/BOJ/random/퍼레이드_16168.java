package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퍼레이드_16168 {
    static ArrayList<Integer>[] node;
    static int[][] visited;
    static String result = "NO";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        node = new ArrayList[v+1];
        visited = new int[v+1][v+1];


        for (int i = 0; i < v+1; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }

        for (int i = 1; i < v+1; i++) {
            if (result.equals("YES"))
                break;
            for (int j = 1; j < v+1; j++) {
                Arrays.fill(visited[j], 0);
            }
            dfs(0, i, e);
        }
        System.out.println(result);
    }

    static void dfs(int depth, int cur, int e){
        if(depth == e){
            result = "YES";
            return;
        }
        for (int next : node[cur]) {
            if(visited[cur][next] == 1 || visited[next][cur] == 1)
                continue;

            visited[cur][next] = 1;
            visited[next][cur] = 1;
            dfs(depth+1, next, e);
        }
    }
}
