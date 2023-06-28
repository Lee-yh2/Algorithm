package algolithm.programmers.lv2.짝지어제거하기;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class Solution {
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty())
                stack.push(s.charAt(i));
            else if(stack.peek().equals(s.charAt(i))) {
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }

        answer = stack.isEmpty()?1:0;

        return answer;
    }
}
