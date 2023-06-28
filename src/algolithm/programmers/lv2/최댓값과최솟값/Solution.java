package algolithm.programmers.lv2.최댓값과최솟값;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */
public class Solution {
    public String solution(String s) {
        String answer = "";

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] str = s.split(" ");
        for(String a : str){
            int num = Integer.parseInt(a);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        answer = min +" "+max;

        return answer;
    }
}
