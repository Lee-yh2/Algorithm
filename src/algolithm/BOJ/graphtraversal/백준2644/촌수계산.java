package algolithm.BOJ.graphtraversal.백준2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 촌수계산 {
    static ArrayList<Integer>[] list;
    static int[] isvisit;
    static int end, result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        isvisit = new int[n + 1];
        Arrays.fill(isvisit, -1);
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs(start);
        System.out.println(result);
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        isvisit[start] = 0;
        que.offer(start);
        while (!que.isEmpty()) {
            int curPerson = que.poll();

            if (curPerson == end) {
                result = isvisit[curPerson];
                break;
            }

            for (int a : list[curPerson]) {
                if (isvisit[a] != -1) continue;

                isvisit[a] = isvisit[curPerson] + 1;
                que.offer(a);
            }
        }
    }
}
