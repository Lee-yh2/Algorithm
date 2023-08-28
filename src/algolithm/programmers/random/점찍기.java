package algolithm.programmers.random;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107
 */
public class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;

        long dd = (long)d*d;
        for (int i = 0; i * k <= d; i++) {
                long x = (long)i*k;
                answer += (int)(Math.sqrt(dd - (x*x)) / k)+1;
        }

        return answer;
    }
}
