package algolithm.BOJ.bruteforce.백준15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static int[][] s;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        check = new boolean[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (m = 1; m < n; m++){
            bt(0,0);
        }
        System.out.print(result);
    }

    static void bt(int depth, int start) {
        if (depth == m) {
            int Ssum = 0;
            int Lsum = 0;
            for (int i = 0; i < n - 1; i++)
                for (int j = i+1; j < n; j++) {
                    if (check[i] && check[j])
                        Ssum += s[i][j] + s[j][i];
                    if (!check[i] && !check[j])
                        Lsum += s[i][j] + s[j][i];
                }
            result = Math.min(result, Math.abs(Ssum - Lsum));
            return;
        }
        for (int i = start; i < n; i++) {
            check[i] = true;
            bt(depth + 1, i + 1);
            check[i] = false;
        }
    }
}
