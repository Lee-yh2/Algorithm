package algolithm.BOJ.dp.백준10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 *      1   2   3   4   5
 *    1 1   0
 *    2     1
 *    3         1
 *    4             1
 *    5                 1
 *
 *
 */

public class 팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n+1];
        int[][] dp = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        isPalindrome(n, list, dp);

        int m = Integer.parseInt(br.readLine());
        while (m-- >0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e]).append("\n");
        }

        System.out.print(sb);
    }

    public static void isPalindrome(int n, int[] list, int[][] dp){
        for(int i = 1; i <= n; i++){
            dp[i][i] = 1;  // 1자리일때

            if(list[i] == list[i-1])
                dp[i-1][i] = 1;
        }

        for(int i = 2; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                if(list[j] == list[j+i] && dp[j+1][j+i-1] == 1){
                    dp[j][j+i] = 1;
                }
            }
        }
    }
}
