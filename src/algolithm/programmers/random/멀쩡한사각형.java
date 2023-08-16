package algolithm.programmers.random;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 */
public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = 0;

        if(w == 1 || h == 1)
            return 0;
        else if(w == h)
            return (long)w*h-w;

        for (int i = 1; i < h; i++) {
            long l = (long) i * w;
            answer += l/h;
        }

        return answer*2;
    }
}
