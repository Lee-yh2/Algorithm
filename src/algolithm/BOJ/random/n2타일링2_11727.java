package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 - l
 * 2 - ll  =  ㅁ
 * 3 - lll l= =l lㅁ ㅁl
 * 4 - llll l=l =ll ll= lㅁ ㅁl == llㅁ ㅁll ㅁㅁ lㅁl
 */
public class n2타일링2_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n+1; i++) {
            dp[i] = (dp[i-1] + (dp[i-2] * 2)) % 10007;
        }
        System.out.println(dp[n]);
    }
}
