package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영재의시험_19949 {
    static int result = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bf(0, new int[10], 0);
        System.out.println(result);
    }

    public static void bf(int depth, int[] answer, int sum){
        if(depth == 10){
            if(sum >= 5)
                result++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if(depth > 1 && answer[depth-2] == i && answer[depth-1] == i)
                continue;

            int a = sum;
            if (i == arr[depth])
                a++;

            answer[depth] = i;
            bf(depth+1, answer, a);
        }
    }
}
