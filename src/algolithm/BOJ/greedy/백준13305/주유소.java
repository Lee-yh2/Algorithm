package algolithm.BOJ.greedy.백준13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] road = new long[n-1];
        long[] price = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        long minprice = price[0];
        long result = road[0]*price[0];
        for(int i = 1; i < n-1; i++){
            if(minprice > price[i]){
                minprice = price[i];
            }
            result += minprice*road[i];
        }
        System.out.println(result);
    }
}
