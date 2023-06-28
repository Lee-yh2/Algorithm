package algolithm.BOJ.graphtraversal.백준1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pr2 {
    static int n, m, v;
    static ArrayList<Integer>[] list;
    static boolean[] isVisit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        isVisit = new boolean[n+1];

        for(int i = 1; i < n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        for(int i = 1; i < n+1; i++){
            Collections.sort(list[i]);
        }

        dfs(v);
        sb.append("\n");
        Arrays.fill(isVisit, false);
        bfs();

        System.out.println(sb);
    }

    public static void dfs(int start){
        isVisit[start] = true;
        sb.append(start).append(" ");

        for(int a:list[start]){
            if(isVisit[a]) continue;
            dfs(a);
        }
    }

    public static void bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        isVisit[v] = true;

        while (!que.isEmpty()){
            int cur = que.poll();

            sb.append(cur).append(" ");
            for(int a: list[cur]){
                if(isVisit[a]) continue;

                que.add(a);
                isVisit[a] = true;
            }
        }
    }
}
