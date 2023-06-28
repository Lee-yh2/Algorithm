package algolithm.programmers.lv2.최솟값만들기;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        int length = B.length;

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length-1-i];
        }

        return answer;
    }
}
