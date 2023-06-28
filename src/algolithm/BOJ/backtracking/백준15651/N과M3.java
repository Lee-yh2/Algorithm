package algolithm.BOJ.backtracking.백준15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M3 {
    static int n, m;
    static int[] nList;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nList = new int[m];

        bf(0);
        System.out.println(sb);

    }

    static void bf(int depth){
        if(depth == m){
            for(int i = 0; i<m; i++) {
                    sb.append(nList[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < n; i++) {
            nList[depth] = i+1;
            bf(depth + 1);
        }

    }
}
