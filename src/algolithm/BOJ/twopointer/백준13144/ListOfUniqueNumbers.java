package algolithm.BOJ.twopointer.백준13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] check = new int[100001];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;
        long result = 0;
        while(true){
            if(R == n){
                if(L == n) break;

                result += R - L;
                L++;
            }
            else if(check[list[R]] == 0){
                check[list[R]]++;
                R++;
            }else if(check[list[R]] > 0){
                result += R - L;  //원래는 (R-1) - L + 1;
                check[list[L]]--;
                L++;
            }
        }
        System.out.println(result);
    }
}
