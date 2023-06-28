package algolithm.BOJ.twopointer.백준1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);
        int L = 0;
        int R = n-1;
        int result = 0;
        while(L < R){
            int sum = list[L] + list[R];

            if(sum == m){
                result++;
                L++;
                R--;
            }else if(sum > m){
                R--;
            }else if(sum < m){
                L++;
            }
        }
        System.out.print(result);
    }
}
