package algolithm.programmers.lv2.땅따먹기;

public class Solution {

    int solution(int[][] land) {
        int answer = 0;

       int n = land.length;
       int m = 4;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int max = 0;
                for (int k = 0; k < m; k++) {
                    if(j == k)
                        continue;
                    max = Math.max(max, land[i-1][k]);
                }

                land[i][j] += max;
                answer = Math.max(answer, land[i][j]);
            }
        }

        return answer;
    }
}
