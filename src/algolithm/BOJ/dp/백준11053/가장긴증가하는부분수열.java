package algolithm.BOJ.dp.백준11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;

            for(int j = 0; j < i; j++){
                if(list[i] > list[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);

    }
}
