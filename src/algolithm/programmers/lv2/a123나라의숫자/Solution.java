package algolithm.programmers.lv2.a123나라의숫자;

import java.util.Stack;

/**
 * 3으로 나누면?
 *
 * 1 = 1    0   1
 * 2 = 2    0   2
 * 3 = 4    1   0
 * 4 = 11   1   1
 * 5 = 12   1   2
 * 6 = 14   2   0
 * 7 = 21   2   1
 * 8 = 22   2   2
 * 9 = 24   3   0
 * 여기까지는 나머지가 0 일때 값 - 1 하고 4
 *
 * 10 = 41  3   1
 * 11 = 42  3   2
 * 12 = 44  4   0
 * 13 = 111 4   1
 * 14 = 112 4   2
 * 15 = 114 5   0
 * 16 = 121 5   1
 * 17 = 122 5   2
 * 18 = 124 6   0
 * 19 = 141 6   1
 * 20 = 142 6   2
 * 21 = 144 7   0
 *
 *
 * 아 dp구나
 * 3으로 나눈 나머지가 0일때
 * dp[i/3 - 1]*10 + 4
 * 나머지가 0이 아닐때
 * dp[i/3]*10 + i%3
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().solution(48421451);
    }

    public String solution(int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int remainder = n%3;
            n = n/3;

            if(remainder == 0){
                n--;
                remainder = 4;
            }
            sb.append(remainder);
        }

        answer = sb.reverse().toString();

        //dp로 풀었을 때 정답이었으나 효율성에서 탈락했다.
        /*
        long[] dp = new long[n+1];

        for (int i = 1; i < n+1; i++) {
            if(i%3 == 0){
                dp[i] = (dp[(i/3)-1]*10) + 4;
            }else{
                dp[i] = (dp[i/3]*10) + (i%3);
            }
        }
        answer = String.valueOf(dp[n]);
         */

        System.out.println(answer);
        return answer;
    }
}
