package algolithm.BOJ.dp.백준12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] before = new int[n+1];

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1]+1;
            before[i] = i-1;

            if(i%3 == 0 && dp[i] > dp[i/3]+1){
                dp[i] = dp[i/3]+1;
                before[i] = i/3;
            }
            if(i%2 == 0 && dp[i] > dp[i/2]+1){
                dp[i] = dp[i/2]+1;
                before[i] = i/2;
            }
        }
        sb.append(dp[n]).append("\n");

        int a = n;
        while (a > 0){
            sb.append(a).append(" ");
            a = before[a];
        }

        System.out.println(sb);
    }
}
