package algolithm.BOJ.twopointer.백준1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 소수의연속합 {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        setPrimeList(n);

        int L = 0;
        int R = 0;
        int result = 0;
        int size = list.size();
        int sum = 2; //list.get(R)은 1 때 오류남

        while (R < size) {
            if (n == sum) {
                result++;
            }
            if (n > sum) {
                R++;
                if (R < size)
                    sum += list.get(R);
            }else{
                sum -= list.get(L);
                L++;
            }
        }
        System.out.println(result);
    }

    public static void setPrimeList(int n) {
        boolean prime[] = new boolean[n + 1];

        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i)
                    prime[j] = true;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!prime[i])
                list.add(i);
        }
    }
}
