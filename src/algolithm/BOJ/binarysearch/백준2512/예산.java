package algolithm.BOJ.binarysearch.백준2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int start = 0;
        int end = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, list[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (list[i] >= mid)
                    sum += mid;
                else
                    sum += list[i];
            }

            if (sum <= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
