package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수 * 최소 공배수 = x * y (단 x, y는 최대 공약수의 배수)
 */
public class 공약수_2436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int maxDiv = Integer.parseInt(st.nextToken());
        int minMul = Integer.parseInt(st.nextToken());

        long xy = (long) maxDiv * minMul;
        int[] answer = new int[2];
        answer[0] = maxDiv;
        answer[1] = minMul;
        // 최대공약수의 배수 탐색
        for (int i = 2*maxDiv; i < Math.sqrt(xy); i += maxDiv) {
            if(xy % i == 0){
                long tmp = xy / i;
                if(maxDiv(i, tmp) == maxDiv) {
                    if(answer[0]+answer[1] > i+tmp){
                        answer[0] = i;
                        answer[1] = (int) tmp;
                    }
                }
            }
        }

        System.out.println(answer[0]+" "+answer[1]);
    }
    //유클리드 호제법?
    //- a와 b의 최대공약수는 b와 a%b의 최대 공약수와 같다
    private static long maxDiv(long a, long b){
        return b==0? a:maxDiv(b, a%b);
    }
}
