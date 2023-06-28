package algolithm.programmers.lv2.숫자의표현;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */
public class Solution {
    public int solution(int n) {
        int answer = 0;

        int sum = 1;
        int s = 1;
        int e = 1;
        while (s <= n){
            if(sum == n){
                answer++;
                sum -= s;
                s++;
            }else if(sum > n){
                sum -= s;
                s++;
            }else if(sum < n){
                e++;
                sum += e;
            }
        }

        return answer;
    }
}
