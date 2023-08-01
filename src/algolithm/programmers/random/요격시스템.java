package algolithm.programmers.random;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
public class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        int maxEnd = 0;

        Arrays.sort(targets, (s, e)->s[1]-e[1]);

        for(int i = 0; i < targets.length; i++){
            int s = targets[i][0];
            int e = targets[i][1];

            if(s<maxEnd)
                continue;
            else{
                maxEnd = Math.max(maxEnd, e);
                answer++;
            }

        }

        return answer;
    }
}
