package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크연결_1922 {
    static ArrayList<Node>[] computers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        computers = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            computers[a].add(new Node(b, c));
            computers[b].add(new Node(a, c));
        }
        System.out.println(prim());

    }

    static int prim(){
        int sum = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.connect])
                continue;

            visited[cur.connect] = true;
            sum += cur.cost;

            for (Node next: computers[cur.connect]){
                pq.add(new Node(next.connect, next.cost));
            }
        }

        return sum;
    }

    static class Node implements Comparable<Node>{
        int connect;
        int cost;

        public Node(int connect, int cost) {
            this.connect = connect;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
