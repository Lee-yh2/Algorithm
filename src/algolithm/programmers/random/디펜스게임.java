package algolithm.programmers.random;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 */
public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            n -= enemy[i];

            if(n < 0){
                if(k > 0 && !pq.isEmpty()){
                    n += pq.poll();
                    k--;
                }else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}
