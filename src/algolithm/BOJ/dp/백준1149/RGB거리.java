package algolithm.BOJ.dp.백준1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1 = 빨초파중 가장 작은수
 * 2 = 1이 빨일경우 - 초, 파 중 비교
 *     1이 초일경우 - 빨, 파 중 비교
 *     1이 파일경우 - 빨, 초 중 비교
 *
 * dp[i][1] = i-1의 초 파 비교
 * dp[i][2] = 빨 파 비교
 * dp[i][3] = 빨 초 비교
 */
public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n+1][4];
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
            list[i][3] = Integer.parseInt(st.nextToken());
        }

      for(int i = 2; i <= n; i++){
          list[i][1] += Math.min(list[i-1][2],list[i-1][3]);
          list[i][2] += Math.min(list[i-1][1],list[i-1][3]);
          list[i][3] += Math.min(list[i-1][1],list[i-1][2]);
      }

      int result = Integer.MAX_VALUE;
      for(int i = 1; i <= 3; i++){
          result = Math.min(result, list[n][i]);
      }

        System.out.print(result);
    }
}
