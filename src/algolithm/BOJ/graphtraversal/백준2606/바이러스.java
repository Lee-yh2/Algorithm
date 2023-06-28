package algolithm.BOJ.graphtraversal.백준2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스 {
    static ArrayList<Integer>[] list;
    static Boolean[] isVisit;
    static int cnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        isVisit = new Boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
            isVisit[i] = false;
        }

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            list[c1].add(c2);
            list[c2].add(c1);
        }
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int start) {
        isVisit[start] = true;
        cnt++;
        for (int a : list[start]) {
            if (isVisit[a]) continue;

            dfs(a);
        }
    }
}
