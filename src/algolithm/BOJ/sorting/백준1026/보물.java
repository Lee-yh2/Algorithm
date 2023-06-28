package algolithm.BOJ.sorting.백준1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        int[][] AB = new int[2][n];
        for(int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                AB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(AB[0]);
        Arrays.sort(AB[1]);

        for(int i = 0; i < n; i++){
            result += AB[0][i]*AB[1][n-i-1];
        }

        System.out.println(result);

    }
}
