package algolithm.BOJ.bruteforce.백준1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        String str;
        for(int i = 1; i <= n; i++){
            if(i <= 99) {
                cnt++;
            }
            else{
                str = String.valueOf(i);
                int[] gapNum = new int[str.length()-1];
                for(int j = 0; j < str.length()-1; j++){
                    gapNum[j] = (str.charAt(j)-'0')-(str.charAt(j+1)-'0');
                }
                boolean check = true;
                int a = gapNum[0];
                for(int j = 1; j < gapNum.length; j++){
                    if(a != gapNum[j]) {
                        check = false;
                        break;
                    }
                }
                if(check) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
