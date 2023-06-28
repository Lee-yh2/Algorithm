package algolithm.BOJ.dp.백준2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 = 10
 * 2 = 10 + 20
 * 3 = 10(1) + 15 or 0(0)+20 + 15 중 더 큰거 35
 * 4 = 30(2) + 25 or 10(1)+15 + 25 중 더 큰거 55
 * 5 = 35(3) + 10 or 30(2)+25 + 10          65
 * 6 = 55(4) + 20 or 35(3)+10 + 20          75
 *
 *  dp[i-2] + list[i] or dp[i-3] + list[i-1] + list[i]
 *  3번을 연속해서 밟으면 안된다.
 */
public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n+1];

        for(int i = 1; i <= n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = list[1];
        if(n >= 2)
            dp[2] = list[1]+list[2];
        if(n >= 3){
            for(int i = 3; i <= n; i++){
                dp[i] = Math.max(dp[i-2] + list[i], dp[i-3] + list[i-1] + list[i]);
            }
        }

        System.out.print(dp[n]);
    }
}
