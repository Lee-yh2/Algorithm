package algolithm.BOJ.backtracking.백준15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M4 {
    static StringBuilder sb;
    static int n, m;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[m];

        bt(0, 0);
        System.out.println(sb);
    }

    static void bt(int depth, int start){
        if(depth == m){
            for(int a: list)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = start; i < n; i++){
            list[depth] = i+1;
            bt(depth + 1, i);
        }
    }
}
