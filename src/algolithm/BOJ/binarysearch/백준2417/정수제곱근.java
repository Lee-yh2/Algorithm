package algolithm.BOJ.binarysearch.백준2417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수제곱근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long L = 0, R = n;
        long result = 0;
        while (L <= R) {
            long mid = (L + R) / 2;
            long pow = (long) Math.pow(mid, 2);
//          if(mid*mid >= n)으로 하면 왜 이상하게 나올까????
            if (pow >= n) {
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

//      long result = (long) Math.sqrt(n);
//      if(result*result < n) result++;
        System.out.println(result);

    }
}
