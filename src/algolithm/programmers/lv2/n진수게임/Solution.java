package algolithm.programmers.lv2.n진수게임;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */
public class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        String str = "";
        int num = 0;
        while (str.length() <= t*m){
           str += Integer.toString(num, n);
           num++;
        }

        for (int i = 0; i < t; i++) {
            answer += str.charAt((p-1)+(m*i));
        }

        return answer.toUpperCase();
    }
}
