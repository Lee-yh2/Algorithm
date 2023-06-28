package algolithm.BOJ.twopointer.백준1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;
        int sum = list[R];
        int result = Integer.MAX_VALUE;
        while (R < n) {
            if (sum >= s) {
                result = Math.min(result, R - L + 1);
                sum -= list[L];
                L++;
            } else {
                R++;
                if (R < n)
                    sum += list[R];
            }
        }
        System.out.print(result == Integer.MAX_VALUE ? 0 : result);
    }
}
