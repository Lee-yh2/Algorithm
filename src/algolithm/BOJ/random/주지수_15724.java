package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  9   23  52  59
 *  10  55  90
 *  31  102
 *  39
 *
 *  90 -
 *  O(nm)
 */
public class 주지수_15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = map[i][j]+map[i-1][j]+map[i][j-1]-map[i-1][j-1];
            }
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
