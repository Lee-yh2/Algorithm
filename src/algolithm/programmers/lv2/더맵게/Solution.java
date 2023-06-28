package algolithm.programmers.lv2.더맵게;

import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (pq.peek() < K){
            int a = pq.poll();
            int b = pq.poll() * 2;

            pq.add(a+b);
            answer++;

            if(pq.size() == 1){
                if(pq.peek() < K){
                    answer = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
