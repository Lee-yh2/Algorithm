package algolithm.BOJ.dp.백준12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] list = new int[n+1][2];
        int[][] dp = new int[n+1][k+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= k; i++){ //무게
            for(int j = 1; j <= n; j++){ // list
                dp[j][i] = dp[j-1][i];
                if(i - list[j][0] >= 0){
                    dp[j][i] = Math.max(dp[j-1][i], list[j][1] + dp[j-1][i-list[j][0]]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
