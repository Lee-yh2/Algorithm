package algolithm.BOJ.dp.백준1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = list[0];
        int max = list[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1]+list[i], list[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
