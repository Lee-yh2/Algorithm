package algolithm.BOJ.greedy.백준11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int[] sum = new int[n];
        sum[0] = list[0];
        int result = sum[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i-1] + list[i];
            result += sum[i];
        }
        System.out.println(result);
    }
}
