package algolithm.BOJ.binarysearch.백준3079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 입국심사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] timeList = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            timeList[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, timeList[i]);
        }

        long start = 0;
        long end = (long) max * m;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += mid / timeList[i];
            }

            if (cnt >= m) {
                result = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }

        System.out.println(result);
    }
}
