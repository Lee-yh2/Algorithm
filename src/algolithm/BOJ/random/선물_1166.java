package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 선물_1166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long l = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());
        long h = Integer.parseInt(st.nextToken());

        double s = 0;
        double e = Math.min(l, Math.min(w, h));
        while (s <= e){
            double mid = (s+e)/2;

            if (((long)(l/mid) * (long)(w/mid) * (long)(h/mid)) >= n) {
                if(s == mid) break;
                s = mid;
            }
            else {
                if (e == mid) break;
                e = mid;
            }
        }

        System.out.println(s);
    }
}
