package algolithm.BOJ.twopointer.백준15565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 귀여운라이언 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i< n; i++)
            list[i] = Integer.parseInt(st.nextToken());

        int result = Integer.MAX_VALUE;
        int L = 0;
        int R = 0;
        int cnt = 0;
        if(list[0] == 1)
            cnt++;
        while(R < n){

            if(cnt >= k){
                result = Math.min(result, R-L+1);
                if(list[L] == 1)
                    cnt--;
                L++;
            }else {
                R++;
                if(R < n){
                    if(list[R] == 1)
                        cnt++;
                }
            }
        }
        System.out.print(result==Integer.MAX_VALUE?-1:result);
    }
}
