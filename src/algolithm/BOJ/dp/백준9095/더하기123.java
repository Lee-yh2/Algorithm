package algolithm.BOJ.dp.백준9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 = 1    1
 * 2 = 2    1+1, 2
 * 3 = 4    1+1+1, 1+2, 2+1, 3
 * 4 = 7    1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1
 * 5 = 13   1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1
 *          1+1+3, 1+3+1, 3+1+1, 2+3, 3+2
 *
 *          11111
 *          1121
 *          1211
 *          2111
 *          221
 *          131
 *          311
 *
 *          1112
 *          122
 *          212
 *          32
 *
 *          113
 *          23
 *
 *          dp[i-1] + dp[i-2] + dp[i-3]
 *
 */
public class 더하기123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
