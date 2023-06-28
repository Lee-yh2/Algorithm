package algolithm.BOJ.backtracking.백준15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M1 {
    static int n, m;
    static int[] list;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[m];
        check = new boolean[n];

        bt(0);
        System.out.println(sb);
    }

    static void bt(int depth){
        if(depth == m){
            for(int i = 0; i < m; i++)
                sb.append(list[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            if(check[i])
                continue;
            check[i] = true;
            list[depth] = i+1;
            bt(depth+1);
            check[i] = false;
        }
    }
}
