package algolithm.BOJ.graphtraversal.백준1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] list;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        isVisit = new boolean[n+1];

        for(int i = 1; i < n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i < n+1; i++){
            Collections.sort(list[i]);
        }

        dfs(v);
        sb.append("\n");
        for(int i = 1; i < n+1; i++) {
            isVisit[i] = false;
        }
        bfs(v);

        System.out.println(sb);
    }

    static void dfs(int v){
        isVisit[v] = true;
        sb.append(v).append(" ");
        for(int a:list[v]){
            if(isVisit[a]) continue;

            dfs(a);
        }
    }

    static void bfs(int v){
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        isVisit[v] = true;

        while(!que.isEmpty()){
            int cur = que.poll();
            sb.append(cur).append(" ");
            for(int a: list[cur]){
                if(isVisit[a]) continue;

                que.offer(a);
                isVisit[a] = true;
            }
        }
    }
}
