package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시건설_21924 {

    static long sum = 0;
    static ArrayList<Road>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }
//        Arrays.stream(list).forEach(a -> a = new ArrayList<>());

        long total = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new Road(b, cost));
            list[b].add(new Road(a, cost));
            total += cost;
        }

        long result = bfs(n)?-1:total-sum;
        System.out.println(result);

    }

    public static boolean bfs(int n){
        boolean[] isVisited = new boolean[n+1];
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(1, 0));

        while (!pq.isEmpty()){
            Road cur = pq.poll();

            if(isVisited[cur.building]) continue;

            isVisited[cur.building] = true;
            sum += cur.cost;

            for(Road next : list[cur.building]){
                if (isVisited[next.building]) continue;
                pq.add(next);
            }
        }

        boolean check = false;
        for (int i = 1; i < n+1; i++) {
            if(!isVisited[i]) {
                check = true;
                break;
            }
        }
        return check;
    }

    static class Road implements Comparable<Road>{
        int building;
        int cost;

        public Road(int building, int cost) {
            this.building = building;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }
}
