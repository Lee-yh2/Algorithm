package algolithm.BOJ.bruteforce.num13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준14501 {
    static Counsel[] counsel;
    static int result = Integer.MIN_VALUE;
    static int n;
    static class Counsel{
        int time, price;

        Counsel(int time, int price){
            this.time = time;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        counsel = new Counsel[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            counsel[i] = new Counsel(t, p);
        }
        counselCal(0,0);
        System.out.println(result);
    }

    public static void counselCal(int depth, int sum){
        if(depth == n){
            if(result <sum)
                result = sum;
            return;
        }
        if(depth > n)
            return;
        counselCal(depth + counsel[depth].time, sum + counsel[depth].price);
        counselCal(depth+1, sum);
    }
}
