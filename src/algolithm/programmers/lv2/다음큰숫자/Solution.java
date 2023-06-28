package algolithm.programmers.lv2.다음큰숫자;

/**
 * 1 = 1
 * 2 = 10
 * 3 = 11
 * 4 = 100
 * 5 = 101
 * 6 = 110
 * 7 = 111
 * 8 = 1000
 * 9 = 1001
 * 10 = 1010
 * 11 = 1011
 * 12 = 1100
 * 13 = 1101
 * 14 = 1110
 * 15 = 1111
 * 16 = 10000
 */
public class Solution {
    public int solution(int n) {
        int answer = n;

//        String binary = Integer.toBinaryString(n); // 10진수를 2진수로 바꿔주는 함수
        int cnt = Integer.bitCount(n); // 1의 개수를 반환해주는 함수
        while (true){
            answer++;
            int resultCnt = Integer.bitCount(answer);
            if (cnt == resultCnt)
                break;
        }

//        answer = Integer.parseInt(binary, 2);
        return answer;
    }
}
