package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1058
 */
public class 친구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] friend = new char[n][n];
        boolean[][] isFriend = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                friend[i][j] = str.charAt(j);
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int two = 0;
            for (int j = 0; j < n; j++) {
                if(friend[i][j] == 'Y'){
                    isFriend[i][j] = true;
                    for (int k = 0; k < n; k++) {
                        if(friend[j][k] == 'Y')
                            isFriend[i][k] = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(isFriend[i][j])
                    two++;
            }

            result = Math.max(result, two);
        }

        System.out.print(result);
    }
}
