package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 간선이어가기2_14284 {
    static ArrayList<Point>[] nodes;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        nodes = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes[a].add(new Point(b, c));
            nodes[b].add(new Point(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dijk(s);
        System.out.println(dist[e]);
    }

    static void dijk(int s){
        dist[s] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(s, 0));

        while (!pq.isEmpty()){
            Point cur = pq.poll();
            if(dist[cur.p] < cur.c) continue;

            for(Point next : nodes[cur.p]){
                if(dist[cur.p] + next.c < dist[next.p]){
                    dist[next.p] = dist[cur.p] + next.c;
                    pq.add(new Point(next.p, dist[next.p]));
                }
            }
        }

    }

    static class Point implements Comparable<Point>{
        int p;
        int c;

        public Point(int p, int c) {
            this.p = p;
            this.c = c;
        }

        @Override
        public int compareTo(Point o) {
            return this.c - o.c;
        }
    }
}
