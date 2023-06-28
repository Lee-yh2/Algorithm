package algolithm.programmers.lv2.멀리뛰기;

/**
 * 1    1   1
 * 2    2   11  2
 * 3    3   111 21  12
 * 4    5   1111 211 121 112 22
 */
public class Solution {
    public long solution(int n) {
        long answer = 0;

        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        answer = dp[n];

        return answer;
    }
}
