package algolithm.programmers.lv2.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {93, 30, 55};
        int[] arr2 = {1, 30, 5};
        new Solution().solution(arr1, arr2);
    }
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int n:progresses){
            q.add(n);
        }

        while (!q.isEmpty()){
            int distributeCnt = 0;
            int start = speeds.length - q.size();
            for (int i = start; i < speeds.length; i++) {
                int sum = q.poll() + speeds[i];
                q.add(sum);
            }

            while(!q.isEmpty() && q.peek() >= 100){
                distributeCnt++;
                q.poll();
            }

            if(distributeCnt > 0)
                list.add(distributeCnt);
        }

        return list.stream().mapToInt(n -> n).toArray();
    }
}
