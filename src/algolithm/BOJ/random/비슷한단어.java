package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2607
 */
public class 비슷한단어 {
    static int[] alphbet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String mainStr = br.readLine();
        int mCnt = mainStr.length();

        int answer = 0;
        for (int i = 0; i < n-1; i++) {
            String subStr = br.readLine();
            int sCnt = subStr.length();

            alphbet = new int[26];
            if(Math.abs(mCnt - sCnt) >= 2)
                continue;
            else{
                if(mCnt >= sCnt) {
                    for (int j = 0; j < sCnt; j++) {
                        alphbet[subStr.charAt(j)-'A']++;
                    }
                    answer += checkWord(mainStr, mCnt);
                }else {
                    for (int j = 0; j < mCnt; j++) {
                        alphbet[mainStr.charAt(j)-'A']++;
                    }
                    answer += checkWord(subStr, sCnt);
                }
            }
        }

        System.out.println(answer);
    }

    static int checkWord(String Str, int Length){
        int wrong = 0;

        for (int i = 0; i < Length; i++) {
            if(alphbet[Str.charAt(i)-'A'] > 0){
                alphbet[Str.charAt(i)-'A']--;
            }else{
                wrong++;
            }

            if(wrong >= 2)
                break;
        }

        return wrong>=2?0:1;
    }
}
