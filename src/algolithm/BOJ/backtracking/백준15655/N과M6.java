package algolithm.BOJ.backtracking.백준15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M6 {
    static int n, m;
    static int[] sbList, nList;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nList = new int[n];
        sbList = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            nList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nList);
        bt(0, 0);

        System.out.println(sb);
    }

    static void bt(int depth, int start){
        if(depth == m){
            for(int a:sbList)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++){
            sbList[depth] = nList[i];
            bt(depth + 1, i + 1);
        }
    }
}
