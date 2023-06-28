package algolithm.BOJ.bruteforce.num17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준14620 {
    static int[][] soil;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        soil = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<n; j++){
                soil[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        

    }
}
