package algolithm.BOJ.twopointer.백준2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int L = 1;
        int R = 1;
        int result = 0;
        int sum = 1;
        while(R >= L){
            if(sum == n) {
                result++;
            }
            if(sum > n){
                sum -= L;
                L++;
            }else if(sum <= n){
                R++;
                sum += R;
            }
        }
        System.out.println(result);
    }
}
