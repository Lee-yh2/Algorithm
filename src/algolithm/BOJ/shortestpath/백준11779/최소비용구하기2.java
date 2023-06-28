package algolithm.BOJ.shortestpath.백준11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int end, cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

public class 최소비용구하기2 {
    static int n, m;
    static ArrayList<Node>[] list;
    static boolean[] isVisit;
    static int[] dist;
    static int[] preNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            list[i] = new ArrayList<>();
        }

        isVisit = new boolean[n+1];
        dist = new int[n+1];
        preNode = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        sb.append(dist[end]).append("\n");

        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (preNode[end] != 0){
            cnt++;
            stack.push(preNode[end]);
            end = preNode[end];
        }
        sb.append(cnt).append("\n");
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0;
        preNode[start] = 0;

        while (!pq.isEmpty()){
            Node node = pq.poll();

            if(isVisit[node.end])
                continue;
            isVisit[node.end] = true;

            for(Node a: list[node.end]){
                if(dist[a.end] > dist[node.end] + a.cost){
                    dist[a.end] = dist[node.end] + a.cost;
                    pq.add(new Node(a.end, dist[a.end]));
                    preNode[a.end] = node.end;
                }
            }
        }
    }
}
