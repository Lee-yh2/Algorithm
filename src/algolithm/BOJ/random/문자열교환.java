package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1522
 */
public class 문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();

        int result = Integer.MAX_VALUE;
        int aCnt = 0;
        for (int i = 0; i < str.length; i++) {
            if(str[i] == 'a')
                aCnt++;
        }

        for (int i = 0; i < str.length; i++) {
            int bCnt = 0;
            for (int j = i; j < i + aCnt; j++) {
                if(str[j % str.length] == 'b')
                    bCnt++;
            }
            result = Math.min(result, bCnt);
        }

        System.out.print(result);
    }
}
