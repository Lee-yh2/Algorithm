package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(n,m)/2;
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < r; j++) {
                int temp = arr[i][i];
                for (int k = i+1; k < m-i; k++) {
                    arr[i][k-1] = arr[i][k];
                }
                for (int k = i+1; k < n-i; k++) {
                    arr[k-1][m-1-i] = arr[k][m-1-i];
                }
                for (int k = m-2-i; k >= i; k--) {
                    arr[n-1-i][k+1] = arr[n-1-i][k];
                }
                for (int k = n-2-i; k >= i; k--) {
                    arr[k+1][i] = arr[k][i];
                }

                arr[i+1][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
