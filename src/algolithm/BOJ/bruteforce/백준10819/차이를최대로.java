package algolithm.BOJ.bruteforce.백준10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로 {
    static int n, result = Integer.MIN_VALUE;
    static int[] numList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        numList = new int[n];
        for(int i = 0; i < n; i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }
        bf(0);
        System.out.println(result);
    }

    static void bf(int depth){
        if(depth == n){
            int sum = 0;
            for(int i = 2; i <= n; i++){
                sum += Math.abs(numList[i-2]-numList[i-1]);
            }
            result = Math.max(result, sum);
            return;
        }

        for(int i = depth; i < n; i++){
            swap(i, depth);
            bf(depth + 1);
            swap(i, depth);
        }
    }

    static void swap(int i, int depth){
        int temp = numList[i];
        numList[i] = numList[depth];
        numList[depth] = temp;
    }
}
