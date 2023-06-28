package algolithm.BOJ.twopointer.백준1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간 복잡도
 * 정렬 : nLogn
 * 수마다 가능한지 구해야 하기 때문에 n * n
 * 즉 nLogn + n*n
 * O(n*n)
 *
 * 아 자신을 제외한 두 수의 합만 가능하구나
 */
public class 좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int result = 0;
        for(int i = 0; i < n; i++){
            int x = list[i];
            int L = 0;
            int R = n-1;
            while (R > L){

                int sum = list[L] + list[R];
                if(sum == x && i != R && i != L){
                    result++;
                    break;
                }
                if(sum > x || i == R)
                    R--;
                else if(sum < x || i == L)
                    L++;
            }
        }

        System.out.println(result);
    }
}
