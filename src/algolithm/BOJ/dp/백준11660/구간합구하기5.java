package algolithm.BOJ.dp.백준11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미리 각 행마다 dp를통해 누적값을 구해두고
 * 필요한 범위만 값을 찾아 더해주면?
 *
 * 1  2  3  4
 * 2  3  4  5
 * 3  4  5  6
 * 4  5  6  7
 *
 * 1  3  6  10
 * 2  5  9  14
 * 3  7  12 18
 * 4  9  15 22
 */
public class 구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] list = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                int a = Integer.parseInt(st.nextToken());
                list[i][j] = a;
                dp[i][j] = dp[i][j-1] + a;
            }
        }

        // dp를 구하기 위해서는 n^2이 필요한데 이 안에서는 m이 최대 10만개이기 때문에
        // n^2 * 10만 을 하면 시간이 한참 넘어간다
        while (m-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int i = x1; i<=x2; i++){
                sum += dp[i][y2] - dp[i][y1-1];
            }

            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
