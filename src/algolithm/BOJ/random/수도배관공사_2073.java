package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class 수도배관공사_2073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] dp = new int[d+1];
        dp[0] = Integer.MAX_VALUE;

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            for (int j = d; j >= length ; j--) {
                //모든 수도관들을 한번씩 넣어보고 그중 가장 큰 capacity 선택
                dp[j] = Math.max(dp[j], Math.min(capacity, dp[j-length]));
            }
        }
        System.out.println(dp[d]);
    }
}
