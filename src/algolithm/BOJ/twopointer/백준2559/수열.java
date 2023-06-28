package algolithm.BOJ.twopointer.백준2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = k - 1;
        int sum = 0;
        for(int i = L; i <= R; i++) {
            sum += list[i];
        }
        int result = sum;
        while (R < n-1){
            sum = sum - list[L] + list[R+1];
            result = Math.max(result, sum);
            R++;
            L++;
        }

        System.out.println(result);
    }
}
