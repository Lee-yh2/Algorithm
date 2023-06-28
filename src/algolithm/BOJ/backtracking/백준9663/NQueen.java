package algolithm.BOJ.backtracking.백준9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    static int n, result = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        bt(0);
        System.out.print(result);

    }

    static void bt(int depth){
        if(depth == n){
            result++;
            return;
        }
        for(int i = 0; i < n; i++){
            arr[depth] = i;

            if(check(depth))
                bt(depth + 1);
        }
    }

    static boolean check(int col){
        for(int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) // 같은 행 체크
                return false;

            if(Math.abs(arr[col]-arr[i]) == Math.abs(col-i)) // 대각선 체크
                return false;
        }
        return true;

    }
}
