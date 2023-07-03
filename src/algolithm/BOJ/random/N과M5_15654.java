package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M5_15654 {
    public static int[] nList;
    public static int[] answerList;
    public static boolean[] isChecked;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answerList = new int[m];
        nList = new int[n];
        isChecked = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nList);
        bt(0, n, m);

        System.out.println(sb);
    }

    private static void bt(int depth, int n, int m){
        if(m == depth){
            for(int a : answerList)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isChecked[i]) continue;
            isChecked[i] = true;
            answerList[depth] = nList[i];
            bt(depth+1, n, m);
            isChecked[i] = false;
        }
    }
}
