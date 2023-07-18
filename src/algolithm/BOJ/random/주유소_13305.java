package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] city = new int[n];
        int[] road = new int[n-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long min = city[0];
        long price = min * road[0];
        for (int i = 1; i < n-1; i++) {
            if(min > city[i])
                min = city[i];
            price += min*road[i];
        }
        System.out.println(price);
    }
}
