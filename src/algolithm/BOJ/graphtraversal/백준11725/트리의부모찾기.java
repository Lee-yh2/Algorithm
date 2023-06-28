package algolithm.BOJ.graphtraversal.백준11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
    static ArrayList<Integer>[] treeList;
    static int[] parentNode;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parentNode = new int[n + 1];
        isVisit = new boolean[n + 1];
        treeList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            treeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            treeList[a].add(b);
            treeList[b].add(a);
        }

        bfs();
        for(int i = 2; i < n +1; i++){
            sb.append(parentNode[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        que.add(1);
        isVisit[1] = true;
        while (!que.isEmpty()){
            int node = que.remove();

            for(int a : treeList[node]){
                if(isVisit[a]) continue;

                isVisit[a] = true;
                que.add(a);
                parentNode[a] = node;
            }
        }
    }
}
