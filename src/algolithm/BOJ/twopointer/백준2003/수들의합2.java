package algolithm.BOJ.twopointer.백준2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A[x]는 최대30000 n은 최대 10000개 다 더해도 3억 이므로 int사용
 * 시간복잡도
 * R과 L이 n-1까지 갈 경우 2n
 * 즉 O(n)
 */
public class 수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;
        int result = 0;
        while(R < n){
            int sum = 0;
            for(int i = L; i <= R; i++)
                sum += list[i];

            if(sum == m) {
                result++;
                L++;
                R++;
            }else if(sum < m){
                R++;
            }else if(sum > m){
                L++;
            }
        }
        System.out.print(result);
    }
}
