package algolithm.BOJ.backtracking.백준6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
    static int k;
    static int[] list;
    static boolean[] isUsed;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());

            if(k == 0) break;

            list = new int[k];
            isUsed = new boolean[k];

            for(int i = 0; i < k; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }
            bt(0,0);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bt(int depth, int start){
        if(depth == 6){
            for(int i = 0; i < k; i++){
                if(isUsed[i])
                    sb.append(list[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < k; i++){
            if(isUsed[i]) continue;
            isUsed[i] = true;
            bt(depth+1, i+1);
            isUsed[i] = false;
        }
    }
}
