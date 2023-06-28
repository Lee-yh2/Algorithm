package algolithm.programmers.lv2.카펫;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int totalNum = brown+yellow;
        for (int i = totalNum-1; i > 0 ; i--) {
            if(totalNum % i == 0 && i >= totalNum/i){
                int col = i;
                int row = totalNum/i;

                if(yellow == (col-2)*(row-2)){
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
        }

        return answer;
    }
}
