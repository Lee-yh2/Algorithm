package algolithm.BOJ.twopointer.백준20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        int[] check = new int[100001];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;
        int result = 0;
        check[list[R]]++;
        while (R < n) {
            if (check[list[R]] > k) {
                result = Math.max(result, R - L);
                check[list[L]]--;
                L++;
            } else {
                if (R == n - 1) {
                    result = Math.max(result, R - L + 1);
                }
                R++;
                if (R < n)
                    check[list[R]]++;
            }
        }
        System.out.println(result);

    }
}
