package algolithm.programmers.lv2.하노이의탑;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 *
 * 1    1,3
 * 2    1,2 1,3 2,3
 * 3    1,2 1,3 2,1 3,2 1,2 1,3 2,1 2,3 1,3
 */
public class Solution {
    static int index = 0;
    public int[][] solution(int n) {
        int[][] answer = new int[(int)Math.pow(2, n) - 1][2];

        hanoi(n, 1, 3, 2, answer);

        return answer;
    }

    public void hanoi(int n, int s, int e, int wayPoint, int[][] answer){
        if(n == 1)
            answer[index++] = new int[] {s, e};
        else{
            hanoi(n-1, s, wayPoint, e, answer);
            answer[index++] = new int[] {s, e};
            hanoi(n-1, wayPoint, e, s, answer);
        }
    }
}
