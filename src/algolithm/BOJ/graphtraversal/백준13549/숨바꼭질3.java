package algolithm.BOJ.graphtraversal.백준13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {
    static int n, k, result = Integer.MAX_VALUE;
    static int[] isVisit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.print(result - 1);
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        que.add(n);
        isVisit[n] = 1;
        while (!que.isEmpty()) {
            int cur = que.poll();

            if(cur == k){
                result = Math.min(result, isVisit[cur]);
            }

            if (cur * 2 <= 100000 && isVisit[cur * 2] == 0) {
                isVisit[cur * 2] = isVisit[cur];
                que.add(cur * 2);
            }
            if (cur - 1 >= 0 && isVisit[cur - 1] == 0) {
                isVisit[cur - 1] = isVisit[cur] + 1;
                que.add(cur - 1);
            }
            if (cur + 1 <= 100000 && isVisit[cur + 1] == 0) {
                isVisit[cur + 1] = isVisit[cur] + 1;
                que.add(cur + 1);
            }
        }
    }
}
