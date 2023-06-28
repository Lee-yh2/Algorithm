package algolithm.BOJ.greedy.백준11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i = n-1; i >=0; i--){
            if(list[i] <= k){
                cnt += k / list[i];
                k = k % list[i];
            }
        }
        System.out.println(cnt);
    }
}
