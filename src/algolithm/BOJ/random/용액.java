package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2467
 */
public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] answer = new int[2];

        int n = Integer.parseInt(br.readLine());
        int[] liquid = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int s = 0;
        int e = n-1;
        int min = Integer.MAX_VALUE;
        while (s < e){
            int sum = liquid[s] + liquid[e];

            if (min > Math.abs(sum)){
                min = Math.abs(sum);
                answer[0] = liquid[s];
                answer[1] = liquid[e];
            }

            if(sum > 0)
                e--;
            else if(sum < 0)
                s++;
            else
                break;
        }

        System.out.print(answer[0]+" "+answer[1]);
    }
}
