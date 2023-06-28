package algolithm.BOJ.graphtraversal.백준5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식 {
    static ArrayList<Integer>[] list;
    static int[] isVisit;
    static int freindCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        isVisit = new int[n + 1];
        Arrays.fill(isVisit, -1);

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs();
        System.out.print(freindCnt);

    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        que.add(1);
        isVisit[1] = 0;
        while (!que.isEmpty()) {
            int freind = que.remove();

            if(isVisit[freind] > 2) break;

            for (int a : list[freind]) {
                if (isVisit[a] != -1) continue;

                que.add(a);
                isVisit[a] = isVisit[freind] + 1;
                if (isVisit[a] <= 2)
                    freindCnt++;
            }
        }
    }
}
