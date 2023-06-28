package algolithm.BOJ.dp.백준10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1 = 9   1~9
 * 2 = 17  10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87 ,89, 98
 *         0 - 1
 *         1 - 0 2
 *         2 - 1 3
 *         3 - 2 4
 *         4 - 3 5
 *         5 - 4 6
 *         6 - 5 7
 *         7 - 6 8
 *         8 - 7 9
 *         9 - 8
 *       j
 *     i   0    1   2   3   4   5   6   7   8   9  시작 숫자
 *       1 1    1   1   1   1   1   1   1   1   1
 *       2 1    2   2   2   2   2   2   2   2   1
 *       3 2    3   4   4   4   4   4   4   4   2
 *       4 3    6   7   8   8   8   8   8   6   4
 *       5
 *     자릿수
 *
 *       4
 *       2 -> 0  0?  ? = 1
 *            1  1?  ? = 0, 2
 *            2  2?  ? = 1, 3
 *            .
 *            .
 *       3 -> 0  0??  ? = 1     -> 0 1?
 *            1  1??  ? = 0, 2  -> 1 0?
 *                                   2?
 *
 *       j = 0 -> dp[i][j] = dp[i-1][1]
 *       j = 9 -> dp[i][j] = dp[i-1][8]
 *       j = 1~8 -> dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
 *
 */
public class 쉬운계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][10];

        Arrays.fill(dp[1], 1);

        for(int i = 2; i <=n; i++){
            for(int j = 0; j < 10; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                }else if(j == 9){
                    dp[i][j] = dp[i-1][j-1] % 1000000000;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        long sum = 0;
        for(int i = 1; i<10; i++){
            sum += dp[n][i];
        }
        System.out.println(sum % 1000000000);

    }
}
