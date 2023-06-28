package algolithm.BOJ.binarysearch.백준2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);
        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (left < right) {
            int sum = list[left] + list[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                result[0] = list[left];
                result[1] = list[right];
            }

            if(sum > 0)
                right--;
            else
                left++;
        }
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.println(sb);
    }
}
