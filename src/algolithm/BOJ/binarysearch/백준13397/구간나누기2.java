package algolithm.BOJ.binarysearch.백준13397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간나누기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] list = new int[n];
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, list[i]);
        }

        int left = 0;
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = cntNum(list, mid);

            if (cnt >= m) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    static int cntNum(int[] list, int mid) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int num : list) {
           max = Math.max(max, num);
           min = Math.min(min, num);

            if (max - min > mid) {
                cnt++;
                max = num;
                min = num;
            }
        }
        return cnt;
    }
}
