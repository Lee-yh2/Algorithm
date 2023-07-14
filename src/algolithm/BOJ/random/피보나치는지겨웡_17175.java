package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치는지겨웡_17175 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[51];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 50; i++) {
            dp[i] = (dp[i-2] + dp[i-1] + 1)%1000000007;
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}
