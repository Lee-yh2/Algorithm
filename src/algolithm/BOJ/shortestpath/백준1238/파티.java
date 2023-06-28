package algolithm.BOJ.shortestpath.백준1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end, time;

    public Node(int end, int time) {
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}

public class 파티 {
    static int n, m, x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList[] list = new ArrayList[n+1];
        ArrayList[] reverseList = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            list[i] = new ArrayList<Node>();
            reverseList[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, t));
            reverseList[e].add(new Node(s, t));
        }

        int[] listResult = new int[n+1];
        int[] rvListResult = new int[n+1];
        Arrays.fill(listResult, Integer.MAX_VALUE);
        Arrays.fill(rvListResult,Integer.MAX_VALUE);

        dijkstra(list, listResult);
        dijkstra(reverseList, rvListResult);

        int result = 0;
        for(int i = 1; i < n+1; i++){
            result = Math.max(result, listResult[i]+rvListResult[i]);
        }

        System.out.println(result);
    }

    public static void dijkstra(ArrayList<Node>[] lists, int[] result){
        PriorityQueue<Node> pque = new PriorityQueue<>();

        pque.add(new Node(x, 0));
        boolean[] isVisit = new boolean[n+1];
        result[x] = 0;

        while (!pque.isEmpty()){
            Node node = pque.poll();

            if(isVisit[node.end])
                continue;
            isVisit[node.end] = true;

            for(Node nod: lists[node.end]){
                if(result[nod.end] > result[node.end] + nod.time){
                    result[nod.end] = result[node.end] + nod.time;
                    pque.add(new Node(nod.end, result[nod.end]));
                }
            }
        }
    }
}
