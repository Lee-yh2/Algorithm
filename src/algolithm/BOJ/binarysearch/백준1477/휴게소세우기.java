package algolithm.BOJ.binarysearch.백준1477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 휴게소세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] list = new int[n + 2]; //시작점과 마지막지점 포함

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        list[0] = 0;
        list[n + 1] = l;
        Arrays.sort(list);

        int start = 1;
        int end = l;
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;

            for (int i = 1; i < n + 2; i++) {
                cnt += (list[i] - list[i - 1] - 1) / mid;
            }

            if (cnt > m) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
