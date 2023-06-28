package algolithm.programmers.lv2.조이스틱;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Solution {
    public int solution(String name) {
        // 알파벳 바꾸는 횟수
        int answer = 0;

        // 오른쪽으로 쭉 갈때 가능한 조작횟수
        int move = name.length()-1;

        for (int i = 0; i < name.length(); i++) {
            // A에서 B쪽으로 바꾸는 경우와 Z쪽으로 바꾸는 경우를 비교
            answer += Math.min(name.charAt(i)-'A', ('Z'+1) - name.charAt(i));

            int index = i + 1;
            if(index < name.length() && name.charAt(index) == 'A') {

                // A가 어디까지 이어지는지 확인
                while (index < name.length() && name.charAt(index) == 'A') {
                    index++;
                }
                // GRSAAAAAX
                // 오른쪽으로 쭉 갔다가 다시 왼쪽으로 이동하는 경우
                move = Math.min(move, i * 2 + (name.length() - index));
                // 왼쪽으로 쭉 갔다가 다시 오른쪽으로 이동하는 경우
                move = Math.min(move, (name.length() - index) * 2 + i);
            }
        }
        return answer + move;
    }
}
