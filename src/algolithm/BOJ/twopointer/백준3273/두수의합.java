package algolithm.BOJ.twopointer.백준3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제에서 i < j 라는 조건이 주어졌지만 수만 구하면 되기 때문에 상관없다.
 * 시간복잡도
 * 정렬 nLogn + 투포인터 n
 * O(nLogn)
 */
public class 두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        int x = Integer.parseInt(br.readLine());
        int L = 0;
        int R = n-1;
        int result = 0;
        while (L < R){
           int sum = list[L] + list[R];

           if(sum == x){
               result++;
               L++;
               R--;
           }else if(sum < x)
               L++;
           else if(sum > x)
               R--;
        }
        System.out.print(result);

    }
}
