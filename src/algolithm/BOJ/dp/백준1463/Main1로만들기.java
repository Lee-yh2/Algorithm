package algolithm.BOJ.dp.백준1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 = 0
 * 2 = 1 1*2
 * 3 = 1 1*3
 * 4 = 2 2*2    1+1
 * 5 = 3 -1, 4  1+2
 * 6 = 2 2*3    1+1
 * 7 = 3 -1, 6  1+2
 * 8 = 3 2*4    1+2
 * 9 = 2 3*3    1+1
 * 10 = 3 -1, 9 1+2  원래라면 2*5 4 지만 -1해서 하는경우와 그냥을 비교해서 작은값을 넣자.
 */
public class Main1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 0;
        if (n >= 2)
            dp[2] = 1;
        if (n >= 3)
            dp[3] = 1;
        if (n >= 4) {
            for (int i = 4; i <= n; i++) {
                int minusCnt = dp[i - 1] + 1; //원래 값에서 -1하고 한 경우

                // 2나 3으로 안나누어 질때 minusCnt보다 값이 작아지면 안됨
                int cnt = Integer.MAX_VALUE;
                if (i % 2 == 0) {
                    int a = i / 2;
                    cnt = dp[2] + dp[a];
                }
                if (i % 3 == 0) {
                    int a = i / 3;
                    cnt = Math.min(cnt, dp[3] + dp[a]);
                }

                dp[i] = Math.min(minusCnt, cnt);
            }
        }

        System.out.println(dp[n]);
    }
}
