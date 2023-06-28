package algolithm.BOJ.greedy.백준11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;// n최대 1000000 * 주가 10000 = 100억
            int max = 0;
            for(int i = n-1; i >= 0; i--){
                if(list[i] > max){
                    max = list[i];
                }else{
                    sum += max - list[i];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
