package algolithm.BOJ.bruteforce.백준17626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares {
    static int n, maxNum, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 1;

        int min = 0;
        for(int i = 2; i <= n; i++){
            min = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }

            dp[i] = min + 1;
        }

//        maxNum = (int)Math.sqrt((double)n);
//        bf((double)maxNum, 0);
        System.out.println(dp[n]);
    }

//    static void bf(double max, int sum){
//        if(sum == n){
//            return;
//        }
//        result++;
//        int a = n - (int)(Math.pow(max, 2) + sum); //n에서 최대제곱수를 빼 남은 수를 표시
//        int b = (int)Math.sqrt((double)a); //남은 수에서 제곱근구하기
//        bf((double)b, (int)(Math.pow(max, 2) + sum));
//    }
}
