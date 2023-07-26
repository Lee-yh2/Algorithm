package algolithm.BOJ.random;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 0 1 0 0
 * 0 1 1 1
 * 1 1 1 1
 * 0 1 1 0
 */
public class 가장큰정사각형_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i+1][j+1] = str.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(arr[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;

                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        System.out.println(result*result);
    }
}
