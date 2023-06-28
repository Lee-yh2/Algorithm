package algolithm.BOJ.dp.백준11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 = 1    l
 * 2 = 2    ll, =
 * 3 = 3    lll, =l, l=
 * 4 = 5    llll, =ll, l=l ,ll=, ==
 *
 * i-1 에서 l를 붙이고 i-2 에서 =붙이면 i의 갯수
 * dp[i] = dp[i-1] + dp[i-2];
 */
public class n2타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.print(dp[n]);
    }
}
