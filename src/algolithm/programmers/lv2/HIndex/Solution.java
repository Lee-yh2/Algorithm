package algolithm.programmers.lv2.HIndex;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 *
 * [ 9000, 7000, 10000, 5000, 6000, 3000, 2000, 8000, 4000 ]
 * 정렬후
 * [ 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 ]
 *
 * 1번 이상 인용된 논문 = 10편 >= 1편 이상
 * 2번 이상 인용된 논문 = 10편 >= 2편 이상
 * 3번 이상 인용된 논문 = 10편 >= 3편 이상
 * 4번 이상 인용된 논문 = 10편 >= 4편 이상
 * 5번 이상 인용된 논문 = 10편 >= 5편 이상
 * 6번 이상 인용된 논문 = 10편 >= 6편 이상
 * 7번 이상 인용된 논문 = 10편 >= 7편 이상
 * 8번 이상 인용된 논문 = 10편 >= 8편 이상
 * 9번 이상 인용된 논문 = 10편 >= 9편 이상
 * 10번 이상 인용된 논문 = 10편 >= 10편 이상
 * 11번 이상 인용된 논문 = 10편 < 11편 미만
 *
 * H-Index는 10
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {0,3,7,8,8,10,13,16,16,16,18,20,5,4,6,5,22,22,22,22,22,22,22};
        new Solution().solution(arr);
    }
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if(citations[i] >= h && i+1 <= h){
                answer = h;
                break;
            }
        }

        return answer;
    }
}
