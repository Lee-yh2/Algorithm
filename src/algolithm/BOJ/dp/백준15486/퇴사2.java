package algolithm.BOJ.dp.백준15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  1   2   3   4   5   6   7
 *  3   5   1   1   2   4   2
 *  10  20  10  20  15  40  200
 *
 *  0   0   10  30   0   45   0
 *
 */
public class 퇴사2 {
    final static int TIME = 0;
    final static int PRICE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n+1][2];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            list[i][TIME] = Integer.parseInt(st.nextToken());
            list[i][PRICE] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        int max = 0;
        for(int i = 1; i <= n; i++){

            int finishDay = i+list[i][TIME]-1;
            if(finishDay <= n){
                dp[finishDay] = Math.max(max + list[i][PRICE], dp[finishDay]);
            }

            max = Math.max(max, dp[i]);
        }

        int result = 0;
        for(int i = 1; i <= n; i++){
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
